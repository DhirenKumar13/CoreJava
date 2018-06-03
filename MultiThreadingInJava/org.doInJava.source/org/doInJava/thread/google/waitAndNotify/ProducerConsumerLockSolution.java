package org.doInJava.thread.google.waitAndNotify;

/**
 * 
 * @author DH317097
 */
public class ProducerConsumerLockSolution {

	private static int[] buffer;
	private static int count;
	private static Object lock = new Object();

	private static boolean isVacant(int[] buffer) {
		return count == 0;
	}

	private static boolean isAvailable(int[] buffer) {
		return count == buffer.length;
	}

	static class Producer {
		public void produce() {
			synchronized (lock) {
				while (isAvailable(buffer)) {
				}
				buffer[count++] = 1;
			}
		}
	}

	static class Consumer {
		public void consume() {
			synchronized (lock) {
				while (isVacant(buffer)) {
				}
				buffer[--count] = 0;
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {
		buffer = new int[10];
		count = 0;

		Producer producer = new Producer();
		Consumer consumer = new Consumer();

		Runnable produceTask = () -> {
			for (int i = 0; i < 50; i++) {
				producer.produce();
			}
			System.out.println("Finished Producing ... ");
		};

		Runnable consumeTask = () -> {
			for (int i = 0; i < 50; i++) {
				consumer.consume();
			}
			System.out.println("Finished Consuming ... ");
		};

		Thread produceThread = new Thread(produceTask);
		Thread consumeThread = new Thread(consumeTask);

		consumeThread.start();
		produceThread.start();

		consumeThread.join();
		produceThread.join();

		System.out.println("Data left in buffer is : " + count);
	}
	//It causes deadlock .....
}
