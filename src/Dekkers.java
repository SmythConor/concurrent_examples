/**
 * implementation of dekkers algorithm for two processes
 * Sometimes starves one process
 */
class Dekkers {
	private static int wantp = 0;
	private static int wantq = 0;
	private static int turn = 1;

	public static void main(String[] args) {

		/* First thread */
		Runnable p = new Runnable() {
			@Override
			public void run() {
				while(true) {
					/* Express interest in executing critical section */
					wantp = 1;

					/* Check if q wants to enter also */
					while(wantq == 1) {
						/* If q does want to enter and it's not our turn, so busy-wait */
						if(turn != 1) {
							/* Five up interest while we wait */
							wantp = 0;

							while(turn != 1) {
								//busy-wait
							} 
						}

						/* When it is our turn express interest again */
						wantp = 1;
					}

					System.out.println("Critical " + turn);
					/* Change the turn */
					turn = 2;
					wantp = 0;
				}
			}
		};

		/* Second thread */
		Runnable q = new Runnable() {
			@Override
			public void run() {
				while(true) {
					/* Express interest in executing critical section*/
					wantq = 1;

					/* Check does p want to execute critical section */
					while(wantp == 1) {
						/* Check if it's our turn */
						if(turn != 2) {
							/* Give up interest while we wait */
							wantq = 0;

							while(turn != 2) {
								//Busy-wait
							}
						}

						/* When it is our turn express interest again */
						wantq = 1;
					}

					System.out.println("Critical " + turn);
					/* Change the turn */
					turn = 1;
					wantq = 0;
				}
			}
		};

		Thread p_t = new Thread(p);
		Thread q_t = new Thread(q);

		p_t.start();
		q_t.start();
	}
}
