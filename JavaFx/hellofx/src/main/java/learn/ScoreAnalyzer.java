package learn;

import java.io.*;

public class ScoreAnalyzer {

	public static void main(String[] args) {
		try {
			File file = new File("record.dat");
			FileOutputStream fos = new FileOutputStream(file);
			DataOutputStream dos = new DataOutputStream(fos);

			for (int i = 0; i < 500; i++) {
				int score = (int) (Math.random() * 101);
				dos.writeInt(score);
			}

			dos.close();

			FileInputStream fis = new FileInputStream(file);
			DataInputStream dis = new DataInputStream(fis);

			int totalScore = 0;
			int highScore = 0;
			int countScoresGreaterAverage = 0;

			while (dis.available() > 0) {
				try {
					int currentScore = dis.readInt();
					if (currentScore < 0 || currentScore > 100) {
						throw new IllegalScoreException("Illegal Score Exception: The score must be from 1 to 100.");
					}

					totalScore += currentScore;

					if (currentScore > highScore) {
						highScore = currentScore;
					}
				} catch (IllegalScoreException e) {
					System.out.println(e.getMessage());
					continue;
				}
			}

			double avg = (double) totalScore / 500;

			dis.close();

			System.out.println("The highest score is: " + highScore);
			System.out.println("The average score is: " + avg);

			FileInputStream fis2 = new FileInputStream(file);
			DataInputStream dis2 = new DataInputStream(fis2);

			while (dis2.available() > 0) {
				int currentScore = dis2.readInt();
				if (currentScore > avg) {
					countScoresGreaterAverage++;
				}
			}

			dis.close();

			System.out.println("Number of scores greater than the average: " + countScoresGreaterAverage);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

class IllegalScoreException extends Exception {
	public IllegalScoreException(String message) {
		super(message);
	}
}
