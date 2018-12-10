
import java.util.Scanner;
import com.mollin.yapi.YeelightDevice;
import com.mollin.yapi.exception.YeelightResultErrorException;
import com.mollin.yapi.exception.YeelightSocketException;

/**
 * Program to controler yeelight bulbs
 * 
 * @author Ignacio Belmonte 11 dic. 2018
 */
public class ClasePrincipal {
	static YeelightDevice device = null;
	static Scanner teclado = new Scanner(System.in);

	public static void main(String[] Args) {

		// Instantiate your device (with its IP)
		establecerIPLuz("192.168.100.44");

		encenderApagarLuz();

		elegirColorLuz();

		establecerIntensidad();

	}

	/**
	 * Establece la direccion de red de la bombilla
	 */
	static void establecerIPLuz(String ip) {
		try {
			// Instantiate your device (with its IP)
			device = new YeelightDevice(ip);
		} catch (YeelightSocketException e1) {

			e1.printStackTrace();
		}
	}

	/**
	 * Metodo para encender o apagar la luz
	 */
	static void encenderApagarLuz() {

		do {
			System.out.println("¿Que desea hacer con la bombilla? on/off");
			String respuesta = teclado.nextLine();

			if (respuesta.equals("on")) {
				// Switch on the device
				try {
					device.setPower(true);
				} catch (YeelightResultErrorException | YeelightSocketException e) {

					e.printStackTrace();
				}
				break;
			}
			if (respuesta.equals("off")) {
				try {
					device.setPower(false);
				} catch (YeelightResultErrorException | YeelightSocketException e) {

					e.printStackTrace();
				}

			}
			if (!respuesta.equals("off")) {
				System.out.println("\n\n-Opcion incorrecta-\n\n");
			}
		} while (true);
	}

	/**
	 * 
	 */
	static void elegirColorLuz() {
		do {
			System.out.println("Elige el color de la luz (rojo, verde, azul, rosa, lila, amarillo");
			String respuesta = teclado.nextLine();

			if (respuesta.equals("rojo")) {
				try {

					device.setRGB(255, 0, 0);

				} catch (YeelightResultErrorException | YeelightSocketException e) {

					e.printStackTrace();
				}
				break;
			}

			if (respuesta.equals("verde")) {
				try {

					device.setRGB(0, 255, 0);

				} catch (YeelightResultErrorException | YeelightSocketException e) {

					e.printStackTrace();
				}
				break;
			}

			if (respuesta.equals("azul")) {
				try {

					device.setRGB(51, 204, 255);

				} catch (YeelightResultErrorException | YeelightSocketException e) {

					e.printStackTrace();
				}
				break;
			}

			if (respuesta.equals("rosa")) {
				try {

					device.setRGB(255, 102, 204);

				} catch (YeelightResultErrorException | YeelightSocketException e) {

					e.printStackTrace();
				}
				break;
			}

			if (respuesta.equals("lila")) {
				try {

					device.setRGB(153, 0, 204);

				} catch (YeelightResultErrorException | YeelightSocketException e) {

					e.printStackTrace();
				}
				break;
			}

			if (respuesta.equals("amarillo")) {
				try {

					device.setRGB(255, 255, 102);

				} catch (YeelightResultErrorException | YeelightSocketException e) {

					e.printStackTrace();
				}
				break;
			}
			System.out.println("\n\n-Opcion incorrecta-\n\n");
		} while (true);
	}

	public static void establecerIntensidad() {
		System.out.println("¿Del 1 al 100 cuanta intesidad quieres que tenga la luz?");
		String respuesta = teclado.nextLine();

		try {
			device.setBrightness(Integer.parseInt(respuesta));
		} catch (YeelightResultErrorException | YeelightSocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
