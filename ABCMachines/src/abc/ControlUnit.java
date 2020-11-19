package abc;

/**
 * This class represents the Control Unit for the
 * ABC Machine
 *
 * @author Tiffany Ferderer
 * @version 1.0
 */
public class ControlUnit {

    private ABCMachine machine;

    /**
     * @param machine The ABC machine this ControlUnit belongs to
     */
    public ControlUnit(ABCMachine machine) {
        this.machine = machine;
    }

    /**
     * This method will continuously fetch, decode, execute, and store instructions/data that are
     * loaded into the ABCMachine's memory map. The program "halts" when it reaches an instruction
     * that is zero.
     */
    public void startProcessing() {

        while (!halt()) {
            fetch();
            decodeExecuteStore();
        }

    }

    /**
     *  This method performs the fetch step for the ControlUnit
     *  1. Access the memory address for the next instruction in RAM(memory array) (use the PC register)
     *  2. Load this instruction from memory into the Instruction Register  (IR)
     *  3. Increment the Program Counter (PC) register
     */
    public void fetch() {
        // get machine's memory
       short[] memory = machine.getMemory();

       // get program counter
       byte pc = machine.getPc();

       // get instruction
        short instruction = memory[pc];

        // load instruction into IR
        machine.setIr(instruction);

        // increment pc
        pc = (byte)(pc + 1);
        machine.setPc(pc);

    }

    /**
     *  This method decodes and executes the instruction according to the
     *  ABCMachine Instruction Set and stores the result
     */
    public void decodeExecuteStore() {
        byte opCode = getOpcode();
        short[] registers = machine.getRegisters();
        short[] memory = machine.getMemory();
        short src1 = registers[getSrc1Register()];
        short src2 = registers[getSrc2Register()];

        switch(opCode){
            case 0: // ADD
                registers[getDestRegister()] = machine.getAlu().operate(src1,Operator.ADD,src2);
                break;

            case 1: //SUB
                registers[getDestRegister()] = machine.getAlu().operate(src1,Operator.SUB,src2);
                break;

            case 2: //MULT
                registers[getDestRegister()] = machine.getAlu().operate(src1,Operator.MULT,src2);
                break;

            case 3: //DIV
                registers[getDestRegister()] = machine.getAlu().operate(src1,Operator.DIV,src2);
                break;

            case 4: //ST
                //registers[getMemAddr()] = src1;
                memory[getMemAddr()] = (byte) registers[getSrc1Register()];
                break;
            case 5: //LD
                registers[getSrc1Register()] = memory[getMemAddr()];
                break;

            case 6: //BR
                if(src1 == 4 && machine.getAlu().getStatus() == Nzp.NEGATIVE) {
                    machine.setPc(getMemAddr());
                }
            if(src1 == 2 && machine.getAlu().getStatus() == Nzp.ZERO) {
                machine.setPc(getMemAddr());
            }
            if(src1 == 1 && machine.getAlu().getStatus() == Nzp.POSITIVE) {
                machine.setPc(getMemAddr());
            }

                break;
            case 7: // JMP
                machine.setPc(getMemAddr());
                break;
        }

    }

    /**
     *  This method returns the numerical value stored in bits numbered 14 - 16
     *  of the instruction register (IR) so the proper opcode can be determined
     *  IR     1  1  1  0   0  0  0  0   0  0  0  0   0  0  0  0
     *  Bit # 16 15 14 13  12 11 10  9   8  7  6  5   4  3  2  1
     *
     * @return a number in range 0 - 7
     * 000 - ADD,  001 - SUB, 010 - MULT, 011 - DIV, 100 - ST(ORE), 101 - LD (LOAD)
     * 110 - BR (BRANCH), 111 - JMP (JUMP)
     */
    public byte getOpcode() {
        final byte SHIFT_RIGHT = 13;
        short instruction = machine.getIr();
        // bit shift right
        instruction = (short)(instruction >>> SHIFT_RIGHT);
        return (byte)(instruction & 0b111);
    }

    /**
     *  This method returns the numerical value stored in bits numbered 11 - 13
     * of the instruction register (IR)
     * IR     0  0  0  1   1  1  0  0   0  0  0  0   0  0  0  0
     * Bit # 16 15 14 13  12 11 10  9   8  7  6  5   4  3  2  1 0 0 0
     *
     * @return a number in range 0 - 7 - indicates
     */
    public byte getSrc1Register() {
        final byte SHIFT_RIGHT = 13;
        final byte SHIFT_LEFT = 3;
        short instruction = machine.getIr();
        // bit shift left & right
        instruction = (short)(instruction << SHIFT_LEFT);
        instruction = (short)(instruction >>> SHIFT_RIGHT);

        return (byte)(instruction & 0b111);
    }

    /**
     * TODO: This method returns the numerical value stored in bits numbered 8 - 10
     * of the instruction register (IR)
     * IR     0  0  0  0   0  0  1  1   1  0  0  0   0  0  0  0
     * Bit # 16 15 14 13  12 11 10  9   8  7  6  5   4  3  2  1 0 0 0 0 0 0
     *
     * @return a number in range 0 - 7
     */
    public byte getSrc2Register() {
        final byte SHIFT_RIGHT = 13;
        final byte SHIFT_LEFT = 6;
        //CHange the .getIR
        short instruction = machine.getIr();
        // bit shift left & right
        instruction = (short)(instruction << SHIFT_LEFT);
        instruction = (short)(instruction >>> SHIFT_RIGHT);

        return (byte)(instruction & 0b111);
    }

    /**
     * This method returns the numerical value stored in bits numbered 5 - 7
     * of the instruction register (IR)
     * IR     0  0  0  0   0  0  0  0   0  1  1  1   0  0  0  0
     * Bit # 16 15 14 13  12 11 10  9   8  7  6  5   4  3  2  1 0 0 0 0 0 0 0 0 0
     *
     * @return a number in range 0 - 7
     */
    public byte getDestRegister() {
        final byte SHIFT_RIGHT = 13;
        final byte SHIFT_LEFT = 9;
        short instruction = machine.getIr();
        // bit shift left & right
        instruction = (short)(instruction << SHIFT_LEFT);
        instruction = (short)(instruction >>> SHIFT_RIGHT);

        return (byte)(instruction & 0b111);
    }

    /**
     *  This method returns the numerical value stored in bits numbered 1 - 4
     * of the instruction register (IR)
     * IR     0  0  0  0   0  0  0  0   0  0  0  0   1  1  1  1
     * Bit # 16 15 14 13  12 11 10  9   8  7  6  5   4  3  2  1 0 0 0 0 0 0 0 0 0 0 0 0
     *
     * @return a number in range 0 - 15
     */
    public byte getMemAddr() {
        final byte SHIFT_LEFT = 12;
        final byte SHIFT_RIGHT = 12;
        short instruction = machine.getIr();
        // bit shift left
        instruction = (short)(instruction << SHIFT_LEFT);
        instruction = (short)(instruction >>> SHIFT_RIGHT);

        return (byte)(instruction & 0b1111);
    }

    /**
     * This method tests to see if the next instruction is blank.
     * @return true if next instruction contains all zeros, otherwise false
     */
    public boolean halt() {
        return machine.getMemory()[machine.getPc()] == 0;
    }
}
