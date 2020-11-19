package test;

import abc.*;

/**
 * This class creates an ABC machine and the registers
 * and memory map of the machine are printed to the
 * console for the program(s).
 *
 * @author Tiffany Ferderer
 */
public class ABCDriver
{
	/**
	 * The driver program for the ABC machine.
	 * @param args Command line arguments
	 */
	public static void main(String[] args)
	{
		//create a new ABCMachine and pass it a new program to run
		ABCMachine mach = new ABCMachine("programs/program1.abc");
		mach.runProgram();
		//print out the registers and memory after the program runs
		System.out.println("Register dump");
		mach.printRegisters();
		System.out.println("Memory dump");
		mach.printMemory();
	}
}
