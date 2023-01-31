package ErismannNic;
import robocode.*;

public class PianoBot extends JuniorRobot
{

	public void checkEnemyDistance(){
		if (scannedDistance < 10){ //If the Enemy is to near, drive back.
            back(100);
        }
	}

	public void run() {
		setColors(black, black, black, black, black);

		while(true) {
			turnGunLeft(45);
			ahead(80);
		}
	}

	public void onScannedRobot() {
		System.out.println("Found at: " + scannedAngle + " Dist: " + scannedDistance);
        checkEnemyDistance();
		turnGunTo(scannedAngle);
		fire(3);
	
	}

	public void onHitByBullet() {
		System.out.println("Got hit on Angle: " + hitByBulletAngle);
		turnGunTo(hitByBulletAngle);
		fire(3);
		ahead(200); //Drive faster in the current direction it's moving to avoid bullets or ram somebody.
	}
	
	public void onHitWall() {
		turnRight(120);
		turnGunTo(heading);  //Turn the gun in travel direction.
		ahead(20);
	}
}
