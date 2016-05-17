class Dekkers {
	private static int wantp = 0;
	private static int wantq = 0;
	private static int turn = 1;

	public static void main(String[] args) {
		new Thread(new Runnable() {
			@Override
			public void run() {
				while(true) {
					wantp = 1;
					
					while(wantq == 1) {
						if(turn != 1) {
							wantp = 0;

							while(turn != 1) {
								//System.out.println("waiting");
							} 
						}
						
						wantp = 1;
					}
					
					System.out.println("Critical " + turn);
					turn = 2; 
					wantp = 0;
				}
			}
		}).start();

		new Thread(new Runnable() {
			@Override
			public void run() {
				while(true) {
					wantq = 1;

					while(wantp == 1) {
						if(turn != 2) {
							wantq = 0;

							while(turn != 2) {
								//System.out.println("waiting");
							}
						}

						wantq = 1;
					}

					System.out.println("Critical " + turn);
					turn = 1;
					wantq = 0;
				}
			}
		}).start();
	}
}
