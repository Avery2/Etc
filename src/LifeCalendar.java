import java.awt.Font;
import java.util.Calendar;
import java.util.Scanner;

public class LifeCalendar {
	/*
	 * https://waitbutwhy.com/2014/05/life-weeks.html
	 * 52 weeks = 12 months = 1 year 52*76>80>90 12*76>80>90 36*... //scaling
	 * 4.33 weeks > 1 month
	 */
	public static void main(String[] args) {
		drawTime(52, 80, 1);
//		drawTime(12, 80);
	}

	public static int calcWeeks() {
		Scanner sc = new Scanner(System.in);
		Calendar cal = Calendar.getInstance();

		//Ask for date values
//		System.out.println("How many years old are you? [int]");
//		double yr = sc.nextInt();
//		System.out.println("What month is it? [int]");
//		double mth = sc.nextInt();
//		System.out.println("What day is it? [int]");
//		double day = sc.nextInt();
//		sc.close();
//		return (int) ((yrs * 52) + (mth * 4.33) + (day / 7));

		//Ask for bday
		System.out.println("What is your birthday? [Year]/[Month]/[Day]");
		String bday = sc.nextLine();
		double yr = (double) Integer.parseInt(bday.substring(0, bday.indexOf("/")));
		double mth = (double) Integer.parseInt(bday.substring(bday.indexOf("/")+1, bday.lastIndexOf("/")));
		double day = (double) Integer.parseInt(bday.substring(bday.lastIndexOf("/")+1));
		yr = cal.get(Calendar.YEAR)-yr; System.out.println(yr);
		mth = cal.get(Calendar.MONTH)+1-mth; System.out.println(mth);
		day = cal.get(Calendar.DAY_OF_MONTH)-day; System.out.println(day);
		sc.close();
		System.out.println("Years: "+yr+"\nMonths: "+mth+"\nDays: "+day+"\nWeeks old:"+(int) ((yr * 52) + (mth * 4.33) + (day / 7)));
		return (int) ((yr * 52) + (mth*4.33333333) + (day/7));
	}

	public static void drawTime(int x, int y, int type) {
		// setup window
		double ratio = ((double) x / y); // x:y > x/y 1250:720, 1250/720 = 1.7361
		int xPixel = 1250, yPixel = 720;
		if (2 * ratio > 1.7361) {
			// x max
			xPixel = 1250;
			yPixel = (int) (1250 / ratio);
		}
		if (2 * ratio < 1.7361) {
			// y max
			yPixel = 720;
			xPixel = (int) (720 * ratio);
		}
//		System.out.println("ratio: x/y "+x+"/"+y+" "+ratio);
//		System.out.println("Size: "+xPixel+"x"+yPixel);
		StdDraw.setCanvasSize(xPixel, yPixel);

		// setup scale
		StdDraw.setXscale(0, x);
		StdDraw.setYscale(0, y);

		// draw shapes
		for (double j = y - 1; j > 0; j--) {
			for (double i = 0; i < x; i++) {
				StdDraw.circle(i + .5, j + .5, .3);
//				System.out.println("(" + i + ", " + j + ")");
//				System.out.println("(" + i + .5 + ", " + j + .5 + ")\n");
			}
		}
		int fill=0;
		if (type == 1)
				fill = calcWeeks();
		int foo = 0;
		StdDraw.setPenColor(250, 180, 180);
		for (double j = y - 1; j > 0; j--) {
			for (double i = 0; i < x; i++) {
				if (foo < fill) {
					StdDraw.filledCircle(i + .5, j + .5, .3);
				}
				foo++;
			}
		}
		StdDraw.setPenColor(55, 0, 0);
		Font font = new Font("Arial", Font.BOLD, 25);
		StdDraw.setFont(font);
		foo=1;
//		StdDraw.textLeft(0, y-(y/20), "You are "+(int)fill*100/936+"% done with an 18 year life."); foo++;//specific to weeks
		StdDraw.textLeft(0, y-foo*(y/20), "You are "+(int)fill*100/1560+"% done with an 30 year life."); foo++; //specific to weeks
//		StdDraw.textLeft(0, y-foo*(y/20), "You are "+(int)fill*100/2600+"% done with an 50 year life."); foo++; //specific to weeks
		StdDraw.textLeft(0, y-foo*(y/20), "You are "+(int)fill*100/4160+"% done with an 80 year life."); foo++; //specific to weeks
		StdDraw.setPenColor();
	}
}