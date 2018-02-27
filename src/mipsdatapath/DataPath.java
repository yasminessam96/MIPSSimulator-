package mipsdatapath;

import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
public class DataPath extends javax.swing.JFrame {

  private String instType;
    private int inst;
    private int address;
    private int instNo;
    private int label;
    private int clockCycles= 0;
    private String lblName;
    private ArrayList<ArrayList>instructions = new ArrayList<ArrayList>();
    private JLabel reg[] = new JLabel[29];
    private JLabel mem[] = new JLabel[26];
    public DataPath() {
        initComponents();
        this.setTitle("MIPS datapath");
        this.setVisible(true);
        reg[0] = $zero;
        reg[1] = $at;
        reg[2] = $v0;
        reg[3] = $v1;
        reg[4] = $a0;
        reg[5] = $a1;
        reg[6] = $a2;
        reg[7] = $a3;
        reg[8] = $t0;
        reg[9] = $t1;
        reg[10] = $t2;
        reg[11] = $t3;
        reg[12] = $t4;
        reg[13] = $t5;
        reg[14] = $t6;
        reg[15] = $t7;
        reg[16] = $s0;
        reg[17] = $s1;
        reg[18] = $s2;
        reg[19] = $s3;
        reg[20] = $s4;
        reg[21] = $s5;
        reg[22] = $s6;
        reg[23] = $s7;
        reg[24] = $t8;
        reg[25] = $t9;
        reg[26] = $sp;
        reg[27] = $ra;
        reg[28] = $pcLabel;
        reg[0].setName("$zero");
        reg[1].setName("$at");
        reg[2].setName("$vo");
        reg[3].setName("v1");
        reg[4].setName("$a0");
        reg[5].setName("$a1");
        reg[6].setName("$a2");
        reg[7].setName("$a3");
        reg[8].setName("$t0");
        reg[9].setName("$t1");
        reg[10].setName("$t2");
        reg[11].setName("$t3");
        reg[12].setName("$t4");
        reg[13].setName("$t5");
        reg[14].setName("$t6");
        reg[15].setName("$t7");
        reg[16].setName("$s0");
        reg[17].setName("$s1");
        reg[18].setName("$s2");
        reg[19].setName("$s3");
        reg[20].setName("$s4");
        reg[21].setName("$s5");
        reg[22].setName("$s6");
        reg[23].setName("$s7");
        reg[24].setName("$t8");
        reg[25].setName("$t9");
        reg[26].setName("$sp");
        reg[27].setName("$ra");
        reg[28].setName("$pc");
        
        mem[0] = mem0;
        mem[1] = mem4;
        mem[2] = mem8;
        mem[3] = mem12;
        mem[4] = mem16;
        mem[5] = mem20;
        mem[6] = mem24;
        mem[7] = mem28;
        mem[8] = mem32;
        mem[9] = mem36;
        mem[10] = mem40;
        mem[11] = mem44;
        mem[12] = mem48;
        mem[13] = mem52;
        mem[14] = mem56;
        mem[15] = mem60;
        mem[16] = mem64;
        mem[17] = mem68;
        mem[18] = mem72;
        mem[19] = mem76;
        mem[20] = mem80;
        mem[21] = mem84;
        mem[22] = mem88;
        mem[23] = mem92;
        mem[24] = mem96;
        mem[25] = mem100;
        
        mem[0].setName("1000");
        mem[1].setName("1004");
        mem[2].setName("1008");
        mem[3].setName("1012");
        mem[4].setName("1016");
        mem[5].setName("1020");
        mem[6].setName("1024");
        mem[7].setName("1028");
        mem[8].setName("1032");
        mem[9].setName("1036");
        mem[10].setName("1040");
        mem[11].setName("1044");
        mem[12].setName("1048");
        mem[13].setName("1052");
        mem[14].setName("1056");
        mem[15].setName("1060");
        mem[16].setName("1064");
        mem[17].setName("1068");
        mem[18].setName("1072");
        mem[19].setName("1076");
        mem[20].setName("1080");
        mem[21].setName("1084");
        mem[22].setName("1088");
        mem[23].setName("1092");
        mem[24].setName("1096");
        mem[25].setName("1100");
       
        dataFlow();   
       
    }
    public void dataFlow ()
    {
        address = Integer.parseInt(JOptionPane.showInputDialog("Please enter the starting address :"));
        instNo = Integer.parseInt(JOptionPane.showInputDialog("Please enter the number of all instructions :"));
        for (inst = 1 ; inst <= instNo ; inst++,address+=4)
        {
            clockCycles++;
            clockCyclesLabel.setText(clockCycles + "");
            for (int j = 0 ; j < 26 ; j++)
            {
                if (address == Integer.parseInt(mem[j].getName()))
                {
                    mem[j].setText("inst. " + inst);
                    break;
                }
            }
            instructions.add(new ArrayList());
            //pc.setText(address + "");
            pcLabel.setText(address+"");
            $pcLabel.setText(address+"");
            jLabel5.setText(address+4 + ""); 
            label = JOptionPane.showConfirmDialog(null,"Do you want to label the instruction number "+inst+" ?");
            if (label == 0)
            {
                lblName = JOptionPane.showInputDialog("Please enter the label name :");
                instructions.get(inst-1).add(0, lblName);
            }
            else 
                instructions.get(inst-1).add(0,"0");
            instructions.get(inst-1).add(1,address);
            instType = JOptionPane.showInputDialog("Please enter the instruction type :");
            instructions.get(inst-1).add(2, instType);
        switch (instType)
        {
            case "add" :
            {
                add i= new add();
                i.addData();
                JOptionPane.showMessageDialog(null, "Press OK to go to the next instruction");
            }
            break;
            case "sub" :
            {
                sub i=new sub();
                i.subData();
                JOptionPane.showMessageDialog(null, "Press OK to go to the next instruction");
            }
            break;
            case "addi" :
            {
                addi i = new addi();
                i.addiData();
                JOptionPane.showMessageDialog(null, "Press OK to go to the next instruction");
            }
            break;
            case "lw" :
            {
                lw i = new lw();
                i.lwData();
                JOptionPane.showMessageDialog(null, "Press OK to go to the next instruction");
            }
            break;
            case "sw" :
            {
               sw i = new sw();
               i.swData();
               JOptionPane.showMessageDialog(null, "Press OK to go to the next instruction");
            }
            break;
            case "sll" :
            {
                sll i = new sll();
                i.sllData();
                JOptionPane.showMessageDialog(null, "Press OK to go to the next instruction");
            }
            break;
            case "and" :
            {
               and i = new and();
               i.andData();
               JOptionPane.showMessageDialog(null, "Press OK to go to the next instruction");
            }
            break;
            case "or" :
            {
                or i = new or();
                i.orData();
                JOptionPane.showMessageDialog(null, "Press OK to go to the next instruction");
            }
            break;
            case "nor" :
            {
                nor i = new nor();
                i.norData();
                JOptionPane.showMessageDialog(null, "Press OK to go to the next instruction");
            }
            break;
            case "beq" :
            {
               beq i = new beq();
               i.beqData();
               JOptionPane.showMessageDialog(null, "Press OK to go to the next instruction");
            }
            break;
            case "bne" :
            {
                bne i = new bne();
                i.bneData();
                JOptionPane.showMessageDialog(null, "Press OK to go to the next instruction");
            }
            break;
            case "j" :
            {
                j i = new j(); 
                i.jData();
                JOptionPane.showMessageDialog(null, "Press OK to go to the next instruction");
            }
            break;
            case "jal" :
            {
                jal i = new jal();
                i.jalData();
                JOptionPane.showMessageDialog(null, "Press OK to go to the next instruction");
            }
            break;
            case "jr" :
            {
                jr i = new jr(); 
                JOptionPane.showMessageDialog(null, "Press OK to go to the next instruction");
            }
            break;
            case "slt" :
            {
                slt i = new slt();
                i.sltData();
                JOptionPane.showMessageDialog(null, "Press OK to go to the next instruction");
            }
            break;
            case "slti" :
            {
                slti i = new slti();
                i.sltiData();
                JOptionPane.showMessageDialog(null, "Press OK to go to the next instruction");
            }
            break;
            case "sltu" :
            {
                sltu i = new sltu();
                i.sltuData();
                JOptionPane.showMessageDialog(null, "Press OK to go to the next instruction");
            }
            break;
            case "sltui" :
            {
                sltui i = new sltui();
                i.sltuiData();
                JOptionPane.showMessageDialog(null, "Press OK to go to the next instruction");
            }
            break;
            
        }
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel5 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        mem0 = new javax.swing.JLabel();
        mem8 = new javax.swing.JLabel();
        mem12 = new javax.swing.JLabel();
        mem16 = new javax.swing.JLabel();
        mem20 = new javax.swing.JLabel();
        mem24 = new javax.swing.JLabel();
        mem28 = new javax.swing.JLabel();
        mem32 = new javax.swing.JLabel();
        mem36 = new javax.swing.JLabel();
        mem88 = new javax.swing.JLabel();
        mem68 = new javax.swing.JLabel();
        mem64 = new javax.swing.JLabel();
        mem56 = new javax.swing.JLabel();
        mem72 = new javax.swing.JLabel();
        mem44 = new javax.swing.JLabel();
        mem40 = new javax.swing.JLabel();
        mem92 = new javax.swing.JLabel();
        mem60 = new javax.swing.JLabel();
        $pc = new javax.swing.JLabel();
        mem80 = new javax.swing.JLabel();
        mem76 = new javax.swing.JLabel();
        mem100 = new javax.swing.JLabel();
        mem52 = new javax.swing.JLabel();
        mem96 = new javax.swing.JLabel();
        mem48 = new javax.swing.JLabel();
        mem84 = new javax.swing.JLabel();
        mem4 = new javax.swing.JLabel();
        address0 = new javax.swing.JLabel();
        address4 = new javax.swing.JLabel();
        address8 = new javax.swing.JLabel();
        address12 = new javax.swing.JLabel();
        address16 = new javax.swing.JLabel();
        address20 = new javax.swing.JLabel();
        address24 = new javax.swing.JLabel();
        address28 = new javax.swing.JLabel();
        address32 = new javax.swing.JLabel();
        address36 = new javax.swing.JLabel();
        address40 = new javax.swing.JLabel();
        address44 = new javax.swing.JLabel();
        address48 = new javax.swing.JLabel();
        address52 = new javax.swing.JLabel();
        address56 = new javax.swing.JLabel();
        address60 = new javax.swing.JLabel();
        address64 = new javax.swing.JLabel();
        address68 = new javax.swing.JLabel();
        address72 = new javax.swing.JLabel();
        address76 = new javax.swing.JLabel();
        address80 = new javax.swing.JLabel();
        address84 = new javax.swing.JLabel();
        address88 = new javax.swing.JLabel();
        address92 = new javax.swing.JLabel();
        address96 = new javax.swing.JLabel();
        address100 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jumpLabel = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        branchLabel = new javax.swing.JLabel();
        opCodeLabel = new javax.swing.JLabel();
        memReadLabel = new javax.swing.JLabel();
        memWriteLabel = new javax.swing.JLabel();
        rs = new javax.swing.JLabel();
        rt = new javax.swing.JLabel();
        rd = new javax.swing.JLabel();
        ALUOpLabel = new javax.swing.JLabel();
        immediate16 = new javax.swing.JLabel();
        regDstLabel = new javax.swing.JLabel();
        memToRegLabel = new javax.swing.JLabel();
        ALUSrcLabel = new javax.swing.JLabel();
        regWriteLabel = new javax.swing.JLabel();
        writeReg = new javax.swing.JLabel();
        zeroLabel = new javax.swing.JLabel();
        ANDbeq = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        data1Label = new javax.swing.JLabel();
        ALUResultLabel = new javax.swing.JLabel();
        data2Label = new javax.swing.JLabel();
        ALUControlLabel = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        immediate32 = new javax.swing.JLabel();
        shiftLeft2Label = new javax.swing.JLabel();
        readDataLabel = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        pcLabel = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        zero = new javax.swing.JLabel();
        at = new javax.swing.JLabel();
        v0 = new javax.swing.JLabel();
        v1 = new javax.swing.JLabel();
        a0 = new javax.swing.JLabel();
        a1 = new javax.swing.JLabel();
        a2 = new javax.swing.JLabel();
        a3 = new javax.swing.JLabel();
        t0 = new javax.swing.JLabel();
        t1 = new javax.swing.JLabel();
        t2 = new javax.swing.JLabel();
        t3 = new javax.swing.JLabel();
        t4 = new javax.swing.JLabel();
        t5 = new javax.swing.JLabel();
        t6 = new javax.swing.JLabel();
        t7 = new javax.swing.JLabel();
        s0 = new javax.swing.JLabel();
        s1 = new javax.swing.JLabel();
        s2 = new javax.swing.JLabel();
        s3 = new javax.swing.JLabel();
        s4 = new javax.swing.JLabel();
        s5 = new javax.swing.JLabel();
        s6 = new javax.swing.JLabel();
        s7 = new javax.swing.JLabel();
        $zero = new javax.swing.JLabel();
        $at = new javax.swing.JLabel();
        $v0 = new javax.swing.JLabel();
        $v1 = new javax.swing.JLabel();
        $a0 = new javax.swing.JLabel();
        $a1 = new javax.swing.JLabel();
        $a2 = new javax.swing.JLabel();
        $a3 = new javax.swing.JLabel();
        $t0 = new javax.swing.JLabel();
        $t1 = new javax.swing.JLabel();
        $t2 = new javax.swing.JLabel();
        $t3 = new javax.swing.JLabel();
        $t4 = new javax.swing.JLabel();
        $t5 = new javax.swing.JLabel();
        $t6 = new javax.swing.JLabel();
        $t7 = new javax.swing.JLabel();
        $s0 = new javax.swing.JLabel();
        $s1 = new javax.swing.JLabel();
        $s2 = new javax.swing.JLabel();
        $s3 = new javax.swing.JLabel();
        $s4 = new javax.swing.JLabel();
        $s5 = new javax.swing.JLabel();
        $s6 = new javax.swing.JLabel();
        $s7 = new javax.swing.JLabel();
        t8 = new javax.swing.JLabel();
        t9 = new javax.swing.JLabel();
        sp = new javax.swing.JLabel();
        ra = new javax.swing.JLabel();
        pc = new javax.swing.JLabel();
        $t8 = new javax.swing.JLabel();
        $ra = new javax.swing.JLabel();
        $t9 = new javax.swing.JLabel();
        $sp = new javax.swing.JLabel();
        $pcLabel = new javax.swing.JLabel();
        writeData = new javax.swing.JLabel();
        bneLabel = new javax.swing.JLabel();
        ORLabel = new javax.swing.JLabel();
        ANDbne = new javax.swing.JLabel();
        jrLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        clockCyclesLabel = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        shamtLabel = new javax.swing.JLabel();
        functionLabel = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 102, 102));
        setBounds(new java.awt.Rectangle(0, 0, 940, 560));
        setMinimumSize(new java.awt.Dimension(950, 690));
        setResizable(false);
        getContentPane().setLayout(null);

        jLabel5.setText("0");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(120, 130, 30, 14);

        mem0.setText("0");

        mem8.setText("0");

        mem12.setText("0");

        mem16.setText("0");

        mem20.setText("0");

        mem24.setText("0");

        mem28.setText("0");

        mem32.setText("0");

        mem36.setText("0");

        mem88.setText("0");

        mem68.setText("0");

        mem64.setText("6");

        mem56.setText("4");

        mem72.setText("0");

        mem44.setText("1");

        mem40.setText("0");

        mem92.setText("0");

        mem60.setText("5");

        mem80.setText("0");

        mem76.setText("0");

        mem100.setText("0");

        mem52.setText("3");

        mem96.setText("0");

        mem48.setText("2");

        mem84.setText("0");

        mem4.setText("0");

        address0.setText("1000");

        address4.setText("1004");

        address8.setText("1008");

        address12.setText("1012");

        address16.setText("1016");

        address20.setText("1020");

        address24.setText("1024");

        address28.setText("1028");

        address32.setText("1032");

        address36.setText("1036");

        address40.setText("1040");

        address44.setText("1044");

        address48.setText("1048");

        address52.setText("1052");

        address56.setText("1056");

        address60.setText("1060");

        address64.setText("1064");

        address68.setText("1068");

        address72.setText("1072");

        address76.setText("1076");

        address80.setText("1080");

        address84.setText("1084");

        address88.setText("1088");

        address92.setText("1092");

        address96.setText("1096");

        address100.setText("1100");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent($pc, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(address100)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(address84)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(address72)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(address12)
                                                    .addComponent(address16)
                                                    .addComponent(address20)
                                                    .addComponent(address24)
                                                    .addComponent(address28)
                                                    .addComponent(address32)
                                                    .addComponent(address36)
                                                    .addComponent(address40)
                                                    .addComponent(address44)
                                                    .addComponent(address48)
                                                    .addComponent(address52)
                                                    .addComponent(address64)
                                                    .addComponent(address68)))
                                            .addComponent(address76)
                                            .addComponent(address80))
                                        .addComponent(address88))
                                    .addComponent(address92)
                                    .addComponent(address96)))
                            .addComponent(address8)
                            .addComponent(address4)
                            .addComponent(address0)
                            .addComponent(address56)
                            .addComponent(address60))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(mem100, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
                            .addComponent(mem96, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(mem92, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(mem88, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(mem84, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(mem80, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(mem76, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(mem72, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(mem68, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(mem64, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(mem60, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(mem56, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(mem52, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(mem48, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(mem44, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(mem40, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(mem36, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(mem32, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(mem28, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(mem24, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(mem20, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(mem16, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(mem12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(mem8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(mem4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(mem0, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mem0, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(address0))
                .addGap(0, 0, 0)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mem4, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(address4))
                .addGap(1, 1, 1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mem8, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(address8))
                .addGap(1, 1, 1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mem12, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(address12))
                .addGap(1, 1, 1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mem16, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(address16))
                .addGap(1, 1, 1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mem20, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(address20))
                .addGap(1, 1, 1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mem24, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(address24))
                .addGap(1, 1, 1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mem28, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(address28))
                .addGap(1, 1, 1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mem32, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(address32))
                .addGap(1, 1, 1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mem36, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(address36))
                .addGap(1, 1, 1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mem40, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(address40))
                .addGap(1, 1, 1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mem44, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(address44))
                .addGap(1, 1, 1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mem48, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(address48))
                .addGap(1, 1, 1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mem52, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(address52))
                .addGap(1, 1, 1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mem56, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(address56))
                .addGap(1, 1, 1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mem60, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(address60))
                .addGap(1, 1, 1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mem64, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(address64))
                .addGap(1, 1, 1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mem68, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(address68))
                .addGap(1, 1, 1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mem72, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(address72))
                .addGap(1, 1, 1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mem76, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(address76))
                .addGap(1, 1, 1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mem80, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(address80))
                .addGap(1, 1, 1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mem84, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(address84))
                .addGap(1, 1, 1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mem88, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(address88))
                .addGap(1, 1, 1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mem92, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(address92))
                .addGap(1, 1, 1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mem96, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(address96))
                .addGap(1, 1, 1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mem100, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(address100))
                .addGap(39, 39, 39)
                .addComponent($pc, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(820, 40, 110, 500);

        jLabel6.setText("0");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(620, 90, 40, 20);

        jLabel7.setText("0");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(290, 90, 40, 14);

        jLabel8.setText("0");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(200, 90, 34, 14);

        jumpLabel.setText("0");
        getContentPane().add(jumpLabel);
        jumpLabel.setBounds(330, 154, 30, 20);

        jLabel10.setText("0");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(500, 120, 40, 20);

        branchLabel.setText("0");
        getContentPane().add(branchLabel);
        branchLabel.setBounds(330, 170, 40, 10);

        opCodeLabel.setText("0");
        getContentPane().add(opCodeLabel);
        opCodeLabel.setBounds(180, 200, 40, 14);

        memReadLabel.setText("0");
        getContentPane().add(memReadLabel);
        memReadLabel.setBounds(330, 180, 40, 14);

        memWriteLabel.setText("0");
        getContentPane().add(memWriteLabel);
        memWriteLabel.setBounds(330, 210, 40, 20);

        rs.setText("0");
        getContentPane().add(rs);
        rs.setBounds(180, 260, 50, 20);

        rt.setText("0");
        getContentPane().add(rt);
        rt.setBounds(180, 290, 50, 10);

        rd.setText("0");
        getContentPane().add(rd);
        rd.setBounds(180, 330, 50, 20);

        ALUOpLabel.setText("0");
        getContentPane().add(ALUOpLabel);
        ALUOpLabel.setBounds(330, 200, 40, 20);

        immediate16.setText("0");
        getContentPane().add(immediate16);
        immediate16.setBounds(180, 370, 50, 20);

        regDstLabel.setText("0");
        getContentPane().add(regDstLabel);
        regDstLabel.setBounds(260, 340, 40, 14);

        memToRegLabel.setText("0");
        getContentPane().add(memToRegLabel);
        memToRegLabel.setBounds(330, 190, 40, 20);

        ALUSrcLabel.setText("0");
        getContentPane().add(ALUSrcLabel);
        ALUSrcLabel.setBounds(330, 220, 40, 20);

        regWriteLabel.setText("0");
        getContentPane().add(regWriteLabel);
        regWriteLabel.setBounds(330, 234, 40, 14);

        writeReg.setText("0");
        getContentPane().add(writeReg);
        writeReg.setBounds(270, 290, 40, 14);

        zeroLabel.setText("0");
        getContentPane().add(zeroLabel);
        zeroLabel.setBounds(510, 270, 40, 14);

        ANDbeq.setText("0");
        getContentPane().add(ANDbeq);
        ANDbeq.setBounds(540, 160, 50, 14);

        jLabel27.setText("0");
        getContentPane().add(jLabel27);
        jLabel27.setBounds(580, 150, 40, 14);

        data1Label.setText("0");
        getContentPane().add(data1Label);
        data1Label.setBounds(380, 260, 40, 14);

        ALUResultLabel.setText("0");
        getContentPane().add(ALUResultLabel);
        ALUResultLabel.setBounds(510, 290, 40, 20);

        data2Label.setText("0");
        getContentPane().add(data2Label);
        data2Label.setBounds(380, 290, 40, 10);

        ALUControlLabel.setText("0");
        getContentPane().add(ALUControlLabel);
        ALUControlLabel.setBounds(450, 380, 50, 14);

        jLabel58.setText("0");
        getContentPane().add(jLabel58);
        jLabel58.setBounds(440, 300, 40, 20);

        immediate32.setText("0");
        getContentPane().add(immediate32);
        immediate32.setBounds(380, 370, 40, 20);

        shiftLeft2Label.setText("0");
        getContentPane().add(shiftLeft2Label);
        shiftLeft2Label.setBounds(440, 146, 40, 14);

        readDataLabel.setText("0");
        getContentPane().add(readDataLabel);
        readDataLabel.setBounds(620, 290, 40, 14);

        jLabel3.setText("Memory");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(840, 10, 60, 30);

        pcLabel.setText("0");
        getContentPane().add(pcLabel);
        pcLabel.setBounds(60, 110, 40, 20);

        zero.setText("$zero = ");

        at.setText("$at = ");

        v0.setText("$v0 =");

        v1.setText("$v1 =");

        a0.setText("$a0 =");

        a1.setText("$a1 =");

        a2.setText("$a2 =");

        a3.setText("$a3 =");

        t0.setText("$t0 =");

        t1.setText("$t1 =");

        t2.setText("$t2 =");

        t3.setText("$t3 =");

        t4.setText("$t4 =");

        t5.setText("$t5 =");

        t6.setText("$t6 =");

        t7.setText("$t7 =");

        s0.setText("$s0 =");

        s1.setText("$s1 =");

        s2.setText("$s2 =");

        s3.setText("$s3 =");

        s4.setText("$s4 =");

        s5.setText("$s5 =");

        s6.setText("$s6 =");

        s7.setText("$s7 =");

        $zero.setText("0");

        $at.setText("0");

        $v0.setText("0");

        $v1.setText("0");

        $a0.setText("0");

        $a1.setText("0");

        $a2.setText("0");

        $a3.setText("0");

        $t0.setText("0");

        $t1.setText("0");

        $t2.setText("0 ");

        $t3.setText("0");

        $t4.setText("0");

        $t5.setText("0");

        $t6.setText("0");

        $t7.setText("0");

        $s0.setText("0");

        $s1.setText("0");

        $s2.setText("0");

        $s3.setText("0");

        $s4.setText("0");

        $s5.setText("0");

        $s6.setText("0");

        $s7.setText("0");

        t8.setText("$t8 =");

        t9.setText("$t9 =");

        sp.setText("$sp =");

        ra.setText("$ra =");

        pc.setText("$pc =");

        $t8.setText("0");

        $ra.setText("0");

        $t9.setText("0");

        $sp.setText("1000");

        $pcLabel.setText(" 0");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(pc)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent($pcLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(ra)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent($ra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addComponent(zero)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent($zero, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addComponent(at)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent($at, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addComponent(v0)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent($v0, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addComponent(v1)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent($v1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addComponent(a0)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent($a0, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addComponent(a1)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent($a1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addComponent(a2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent($a2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addComponent(a3)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent($a3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addComponent(t0)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent($t0, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addComponent(t1)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent($t1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addComponent(t2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent($t2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addComponent(t3)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent($t3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addComponent(t4)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent($t4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addComponent(t5)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent($t5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addComponent(t6)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent($t6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addComponent(t7)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent($t7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addComponent(s0)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent($s0, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addComponent(s1)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent($s1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addComponent(s2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent($s2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addComponent(s3)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent($s3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addComponent(s4)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent($s4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addComponent(s5)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent($s5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addComponent(s6)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent($s6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addComponent(s7)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent($s7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(t8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent($t8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(sp)
                                    .addComponent(t9))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent($t9, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent($sp, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(9, 9, 9))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(zero)
                    .addComponent($zero))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(at)
                    .addComponent($at))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(v0)
                    .addComponent($v0))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(v1)
                    .addComponent($v1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(a0)
                    .addComponent($a0))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(a1)
                    .addComponent($a1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(a2)
                    .addComponent($a2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(a3)
                    .addComponent($a3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(t0)
                    .addComponent($t0))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(t1)
                    .addComponent($t1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(t2)
                    .addComponent($t2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(t3)
                    .addComponent($t3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(t4)
                    .addComponent($t4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(t5)
                    .addComponent($t5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(t6)
                    .addComponent($t6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(t7)
                    .addComponent($t7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(s0)
                    .addComponent($s0))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(s1)
                    .addComponent($s1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(s2)
                    .addComponent($s2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(s3)
                    .addComponent($s3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(s4)
                    .addComponent($s4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(s5)
                    .addComponent($s5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(s6)
                    .addComponent($s6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(s7)
                    .addComponent($s7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(t8)
                    .addComponent($t8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(t9)
                    .addComponent($t9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sp)
                    .addComponent($sp))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ra)
                    .addComponent($ra))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent($pcLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pc))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel3);
        jPanel3.setBounds(750, 0, 90, 650);

        writeData.setText("0");
        getContentPane().add(writeData);
        writeData.setBounds(640, 304, 30, 20);

        bneLabel.setText("0");
        getContentPane().add(bneLabel);
        bneLabel.setBounds(350, 234, 34, 20);

        ORLabel.setText("0");
        getContentPane().add(ORLabel);
        ORLabel.setBounds(560, 140, 20, 14);

        ANDbne.setText("0");
        getContentPane().add(ANDbne);
        ANDbne.setBounds(580, 174, 34, 10);

        jrLabel.setText("0");
        getContentPane().add(jrLabel);
        jrLabel.setBounds(240, 130, 34, 14);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("31");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(200, 290, 34, 30);

        jLabel4.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 24)); // NOI18N
        jLabel4.setText("Number of clock cycles : ");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(270, 500, 220, 40);

        clockCyclesLabel.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 24)); // NOI18N
        clockCyclesLabel.setText("0");
        getContentPane().add(clockCyclesLabel);
        clockCyclesLabel.setBounds(480, 490, 50, 60);

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        jLabel9.setText("instruction[10-6]");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(180, 424, 90, 10);

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        jLabel11.setText("shamt");
        getContentPane().add(jLabel11);
        jLabel11.setBounds(480, 310, 40, 20);

        shamtLabel.setText("0");
        getContentPane().add(shamtLabel);
        shamtLabel.setBounds(290, 434, 40, 20);

        functionLabel.setText("0");
        getContentPane().add(functionLabel);
        functionLabel.setBounds(390, 390, 40, 14);

        jLabel2.setIcon(new javax.swing.ImageIcon("C:\\Users\\My PC\\Desktop\\finalf.png")); // NOI18N
        getContentPane().add(jLabel2);
        jLabel2.setBounds(-6, 4, 730, 480);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DataPath.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DataPath.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DataPath.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DataPath.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DataPath().setVisible(true);
            }
        });
    }
abstract class formats 
{
    public formats ()
    {
        initLabels();
    }
    public void initLabels ()
    {
        functionLabel.setText("X");
        jLabel8.setText("0");
        jLabel7.setText("0");
        jLabel10.setText("0");
        shiftLeft2Label.setText("0");
        jLabel27.setText("0");
        jLabel6.setText("0");
        regDstLabel.setText("0");
        branchLabel.setText("0");
        jumpLabel.setText("0");
        memReadLabel.setText("0");
        memToRegLabel.setText("0");
        ALUOpLabel.setText("0");
        memWriteLabel.setText("0");
        ALUSrcLabel.setText("0");
        regWriteLabel.setText("0");
        opCodeLabel.setText("0");
        rs.setText("0");
        rt.setText("0");
        rd.setText("0");
        immediate16.setText("0");
        writeReg.setText("0");
        regDstLabel.setText("0");
        data1Label.setText("0");
        data2Label.setText("0");
        immediate32.setText("0");
        jLabel58.setText("0");
        ALUControlLabel.setText("0");
        ALUResultLabel.setText("0");
        zeroLabel.setText("0");
        ANDbeq.setText("0");
        bneLabel.setText("0");
        ORLabel.setText("0");
        ANDbne.setText("0");
        jrLabel.setText("0");
        readDataLabel.setText("0");
        writeData.setText("0");
    }
}
class rFormat extends formats
{
    protected int rsReg;
    protected int rtReg;
    protected int rdReg;
    public rFormat()
    {
        super();
        regDstLabel.setText(1 + "");
        regWriteLabel.setText(1 + "");
        ALUOpLabel.setText(2 + "");
    } 
}
class add extends rFormat 
{
    private int num1;
    private int num2;
    private int sum;
    
    public add()
    {
       super(); 
       ALUControlLabel.setText(2 + "");
       functionLabel.setText("32");
    }
    public void addData()
    {
        jLabel27.setText(address + 4 + "");
        jLabel6.setText(address + 4 + "");
        String srcReg = JOptionPane.showInputDialog("Please enter the 1st source register: ");
        for(int i = 0 ; i < 29 ; i++)
        {
            if(srcReg.equalsIgnoreCase("$zero")){
            instructions.get(inst - 1).add(3, i);
            num1 = 0;
            }
            else if (srcReg.equalsIgnoreCase(reg[i].getName()))
            {
                instructions.get(inst - 1).add(3, i);
                this.rsReg = i;
                rs.setText(i+"");
                if(reg[i].getText().equals("0")){
                num1 = Integer.parseInt(JOptionPane.showInputDialog("Please enter the number in the 1st source register: "));
                reg[i].setText(num1+"");
                }
                else {
                num1 = Integer.parseInt(reg[i].getText());
                }
                data1Label.setText(num1+"");
                break;
            }  
        }
        String srcReg2 = JOptionPane.showInputDialog("Please enter the 2nd source register: ");
        for(int i=0;i<29;i++)
        {
             if(srcReg2.equalsIgnoreCase("$zero")){
            instructions.get(inst - 1).add(4, i);
            num2 = 0;
            }
            else if (srcReg2.equalsIgnoreCase(reg[i].getName()))
            {
                instructions.get(inst - 1).add(4, i);
                this.rtReg = i;
                rt.setText(i+"");
                if(reg[i].getText().equals("0")){
                num2 = Integer.parseInt(JOptionPane.showInputDialog("Please enter the number in the 2nd source register "));
                reg[i].setText(num2+""); 
                }
                else {
                num2 = Integer.parseInt(reg[i].getText());
                }
                data2Label.setText(num2+"");
                jLabel58.setText(num2+"");
                break;
            }
            
        }
        String dstReg = JOptionPane.showInputDialog("Please enter the destination register: ");
        for (int i = 0 ; i < 29 ; i++)
        {
           if(dstReg.equalsIgnoreCase("$zero")){
          dstReg = JOptionPane.showInputDialog("You can't modify $zero, please enter another register: ");
             if (dstReg.equalsIgnoreCase(reg[i].getName()))
            {
                instructions.get(inst - 1).add(5, i);
                this.rdReg = i;
                writeReg.setText(i+"");
                rd.setText(i+"");
                sum = num2 + num1;
                reg[i].setText(sum + "");
                break;
            }
           }
          else  if (dstReg.equalsIgnoreCase(reg[i].getName()))
            {
                instructions.get(inst - 1).add(5, i);
                this.rdReg = i;
                writeReg.setText(i+"");
                rd.setText(i+"");
                sum = num2 + num1;
                reg[i].setText(sum + "");
                break;
            }
        }
        ALUResultLabel.setText(sum + "");
        writeData.setText(sum + "");    
    }
}
class sub extends rFormat
{
    int num1;
    int num2;
    int diff;
    public sub()
    {
       super();
       ALUControlLabel.setText(6 + "");
       functionLabel.setText("34");  
    }
    public void subData()
    {
        jLabel27.setText(address + 4 + "");
        jLabel6.setText(address + 4 + ""); 
        String srcReg = JOptionPane.showInputDialog("Please enter the 1st source register: ");
        for(int i = 0 ; i < 29 ; i++)
        {
            if(srcReg.equalsIgnoreCase("$zero")){
            instructions.get(inst - 1).add(3, i);
            num1 = 0;
            }
           else if ( srcReg.equalsIgnoreCase(reg[i].getName()))
            {
                instructions.get(inst - 1).add(3, i);
                this.rsReg = i;
                rs.setText(i+"");
                if(reg[i].getText().equals("0")){
                    num1 = Integer.parseInt(JOptionPane.showInputDialog("Please enter the number in the 1st source register "));
                    reg[i].setText(num1+"");
                }
                else {
                    num1 = Integer.parseInt(reg[i].getText());
                }
                data1Label.setText(num1 + "");  
                break;
            }
        }
        String srcReg2 = JOptionPane.showInputDialog("Please enter the 2nd source register: ");
        for(int i = 0 ; i < 29 ; i++)
        {
            if(srcReg2.equalsIgnoreCase("$zero")){
            instructions.get(inst - 1).add(4, i);
            num2 = 0;
            }
          else  if ( srcReg2.equalsIgnoreCase(reg[i].getName()))
            {
                instructions.get(inst - 1).add(4, i);
                this.rtReg = i;
                rt.setText(i + "");
                if(reg[i].getText().equals("0")){
                    num2 = Integer.parseInt(JOptionPane.showInputDialog("Please enter the number in the 2nd source register "));
                    reg[i].setText(num2 + "");
                }
                else {
                    num2 = Integer.parseInt(reg[i].getText());
                }
                data2Label.setText(num2 + "");
                jLabel58.setText(num2 + "");    
                break;
            }
        }
        String dstReg = JOptionPane.showInputDialog("Please enter the destination register: ");
        for (int i = 0 ; i < 29 ; i++)
        {
            if(dstReg.equalsIgnoreCase("$zero")){
          dstReg = JOptionPane.showInputDialog("You can't modify $zero, please enter another register: ");
             if (dstReg.equalsIgnoreCase(reg[i].getName()))
            {
               
                instructions.get(inst - 1).add(5, i);
                this.rdReg = i;
                rd.setText(i + "");
                writeReg.setText(i + "");
                diff = num1 - num2;
                reg[i].setText(diff + "");   
                break;
            }
            }
           
           else if (dstReg.equalsIgnoreCase(reg[i].getName()))
            {
                instructions.get(inst - 1).add(5, i);
                this.rdReg = i;
                rd.setText(i + "");
                writeReg.setText(i + "");
                diff = num1 - num2;
                reg[i].setText(diff + "");   
                break;
            }
        }
        diff = num1 - num2;
        ALUResultLabel.setText(diff+"");
        regDstLabel.setText(diff+"");
    }
}
class sll extends rFormat {
        int num2;
        int shiftAmount;
        int num3;

        public sll() {
            super();
            ALUControlLabel.setText("4");
            functionLabel.setText("0");
        }

        public void sllData() {
            jLabel27.setText(address + 4 + "");
            jLabel6.setText(address + 4 + "");
            String srcReg2 = JOptionPane.showInputDialog("Please enter the source register: ");
            for (int i = 0; i < 29; i++) {
                if(srcReg2.equalsIgnoreCase("$zero")){
                    instructions.get(inst - 1).add(3, i);
                    num2 = 0;
                }
            
                if (srcReg2.equalsIgnoreCase(reg[i].getName())) {
                    instructions.get(inst - 1).add(3, i);
                    rtReg = i;
                    rt.setText(i + "");
                    if (reg[i].getText().equals("0")) {
                        num2 = Integer.parseInt(JOptionPane.showInputDialog("Please enter the number in the source register "));
                        reg[i].setText(num2 + "");
                    } else {
                        num2 = Integer.parseInt(reg[i].getText());
                    }
                    data2Label.setText(num2 + "");
                    break;
                }
            }
            shiftAmount = Integer.parseInt(JOptionPane.showInputDialog("Please enter the shift amount: "));
            shamtLabel.setText(shiftAmount + "");
            instructions.get(inst - 1).add(4, shiftAmount);
            String dstReg = JOptionPane.showInputDialog("Please enter the destination register: ");
            for (int i = 0; i < 29; i++) {
                if(dstReg.equalsIgnoreCase("$zero")){
                    dstReg = JOptionPane.showInputDialog("You can't modify $zero, please enter another register: ");
                }
                if (dstReg.equalsIgnoreCase(reg[i].getName())) {
                    instructions.get(inst - 1).add(5, i);
                    rdReg = i;
                    writeReg.setText(i + "");
                    rd.setText(i + "");
                    num3 = (int) (num2 * (Math.pow(2, shiftAmount)));
                    reg[i].setText(num3 + "");
                }
            }
            ALUResultLabel.setText(num3 + "");
            writeData.setText(num3 + "");
        }
    
    }
class slt extends rFormat {
    int num1;
    int num2;
    int num3;

    public slt(){
        super();
        ALUControlLabel.setText("7");
        functionLabel.setText(42+""); //function
}
    public void sltData()
    {
        jLabel27.setText(address + 4 + "");
        jLabel6.setText(address + 4 + "");
        String srcReg = JOptionPane.showInputDialog("Please enter the 1st source register: ");
        for(int i = 0 ; i < 29 ; i++)
        {
            if(srcReg.equalsIgnoreCase("$zero")){
            instructions.get(inst - 1).add(3, i);
            num1 = 0;
            }
            
            else if (srcReg.equalsIgnoreCase(reg[i].getName()))
            {
                instructions.get(inst - 1).add(3, i);
                rsReg = i;
                rs.setText(i + "");
                if(reg[i].getText().equals("0")){
                    num1 = Integer.parseInt(JOptionPane.showInputDialog("Please enter the number in the 1st source register "));
                    reg[i].setText(num1+"");
                }
                else {
                    num1 = Integer.parseInt(reg[i].getText());
                }
                data1Label.setText(num1+"");
                break;
            }
        }
        String srcReg2 = JOptionPane.showInputDialog("Please enter the 2nd source register: ");
        for(int i = 0 ; i < 29 ; i++)
        {
            if(srcReg2.equalsIgnoreCase("$zero")){
            instructions.get(inst - 1).add(4, i);
            num2 = 0;
            }
            
           else if (srcReg2.equalsIgnoreCase(reg[i].getName())) {
                instructions.get(inst - 1).add(4, i);
                rtReg = i;
                rt.setText(i + "");
                if (reg[i].getText().equals("0")) {
                    num2 = Integer.parseInt(JOptionPane.showInputDialog("Please enter the number in the 2nd source register "));
                    reg[i].setText(num2 + "");
                } else {
                    num2 = Integer.parseInt(reg[i].getText());
                }
                data2Label.setText(num2 + "");
                jLabel58.setText(num2 + "");
                break;
            }
        }
        String dstReg = JOptionPane.showInputDialog("Please enter the destination register: ");
        for (int i = 0 ; i < 29 ; i++)
        {
            if(dstReg.equalsIgnoreCase("$zero")){
          dstReg = JOptionPane.showInputDialog("You can't modify $zero, please enter another register: ");
          if (dstReg.equalsIgnoreCase(reg[i].getName())){
          instructions.get(inst - 1).add(5, i);
                rdReg = i;
                writeReg.setText(i+"");
                rd.setText(i+"");
                if(num1<num2)
                    num3=1;
                else
                    num3=0;
                reg[i].setText(num3+"");
                break;
            }
            }
            
           else if (dstReg.equalsIgnoreCase(reg[i].getName()))
            {
                instructions.get(inst - 1).add(5, i);
                rdReg = i;
                writeReg.setText(i+"");
                rd.setText(i+"");
                if(num1<num2)
                    num3=1;
                else
                    num3=0;
                reg[i].setText(num3+"");
                break;
            }
        }
        ALUResultLabel.setText(num3+"");
        writeData.setText(num3+"");
        regDstLabel.setText(num3+"");
    }
}
        
class sltu extends rFormat {
    int num1;
    int num2;
    int num3;

    public sltu(){
        super();
           ALUControlLabel.setText("7");
           functionLabel.setText(43+"");
    }
    public void sltuData()
    {
        jLabel27.setText(address + 4 + "");
        jLabel6.setText(address + 4 + "");
        String srcReg = JOptionPane.showInputDialog("Please enter the 1st source register: ");
        for(int i = 0 ; i < 29 ; i++)
        {
           
             if(srcReg.equalsIgnoreCase("$zero")){
            instructions.get(inst - 1).add(3, i);
            num1 = 0;
            }
          else  if ( srcReg.equalsIgnoreCase(reg[i].getName()))
            {
                instructions.get(inst - 1).add(3, i);
                rsReg = i;
                rs.setText(i+"");
                if(reg[i].getText().equals("0")){
                    num1 = Integer.parseInt(JOptionPane.showInputDialog("Please enter the number in the 1st source register "));
                    reg[i].setText(num1+"");
                    data1Label.setText(num1+""); 
                }
                else {
                    num1 = Integer.parseInt(reg[i].getText());
                    data1Label.setText(num1+"");
                }
                num1 = Math.abs(num1);
                break;
            }
        }
        String srcReg2 = JOptionPane.showInputDialog("Please enter the 2nd source register: ");
        for(int i = 0 ; i < 29 ; i++)
        {
            if(srcReg2.equalsIgnoreCase("$zero")){
            instructions.get(inst - 1).add(4, i);
            num2 = 0;
        }
            else if ( srcReg2.equalsIgnoreCase(reg[i].getName()))
            {
                instructions.get(inst - 1).add(4, i);
                rtReg = i;
                rt.setText(i+"");
                if(reg[i].getText().equals("0")){
                    num2 = Integer.parseInt(JOptionPane.showInputDialog("Please enter the number in the 2nd source register "));
                    data2Label.setText(num2+"");
                    jLabel58.setText(num2+"");
                    reg[i].setText(num2+"");
                }
                else {
                    num2 = Integer.parseInt(reg[i].getText());
                    data2Label.setText(num2+"");
                    jLabel58.setText(num2+"");
                } 
                num2 = Math.abs(num2);
                break;
            }
        }
        String dstReg = JOptionPane.showInputDialog("Please enter the destination register: ");
        for (int i = 0 ; i < 29 ; i++)
        {
           
           if(dstReg.equalsIgnoreCase("$zero")){
          dstReg = JOptionPane.showInputDialog("You can't modify $zero, please enter another register: ");
          if (dstReg.equalsIgnoreCase(reg[i].getName()))
            {
                instructions.get(inst - 1).add(5, i);
                rdReg = i;
                writeReg.setText(i+"");
                rd.setText(i+"");
                if(num1<num2)
                    num3=1;
                else
                    num3=0;
                
                reg[i].setText(num3+"");
                break;
            }
           }
           else if (dstReg.equalsIgnoreCase(reg[i].getName()))
            {
                instructions.get(inst - 1).add(5, i);
                rdReg = i;
                writeReg.setText(i+"");
                rd.setText(i+"");
                if(num1<num2)
                    num3=1;
                else
                    num3=0;
                
                reg[i].setText(num3+"");
                break;
            }
        }
        ALUResultLabel.setText(num3+"");
        writeData.setText(num3+"");
        regDstLabel.setText(num3+"");
    }
}

    class and extends rFormat {

        int num1;
        int num2;
        int[] bin1 = new int[16];
        int[] bin2 = new int[16];
        int[] bin3 = new int[16];
        public and() {
            super();
            functionLabel.setText(36 + "");
        }
        public void DecToBin(int x, int[] bin) {
            for (int i = 0; i < 16; i++) {
                if (x == 0) {
                    bin[15 - i] = 0;
                } else {
                    bin[15 - i] = x % 2;
                }
                x /= 2;
            }
        }

        public int BinToDec(int[] Dec) {
            int y = 0;
            for (int i = 0; i < 16; i++) {
                if (Dec[15 - i] == 1) {
                    y = (int) (y + Math.pow(2, i));
                } else {
                    y += 0;
                }
            }
            return y;
        }
        public void andData() {
            jLabel27.setText(address + 4 + "");
            jLabel6.setText(address + 4 + "");
            String srcReg2 = JOptionPane.showInputDialog("Please enter the 1st source register: ");
            for (int i = 0; i < 29; i++) {
                
            if(srcReg2.equalsIgnoreCase("$zero")){
            instructions.get(inst - 1).add(3, i);
            num1 = 0;
            }
             else   if (srcReg2.equalsIgnoreCase(reg[i].getName())) {
                    instructions.get(inst - 1).add(3, i);
                    rsReg = i;
                    rs.setText(i + "");
                    if (reg[i].getText().equals("0")) {
                        num1 = Integer.parseInt(JOptionPane.showInputDialog("Please enter the number in the 1st source register "));
                        reg[i].setText(num1 + "");
                    } else {
                        num1 = Integer.parseInt(reg[i].getText());
                    }
                    data1Label.setText(num1 + "");
                    break;
                }
                DecToBin(num1, bin1);
            }
            String srcReg3 = JOptionPane.showInputDialog("Please enter the 2nd source register: ");
            for (int k = 0; k < 29; k++) {
                if(srcReg2.equalsIgnoreCase("$zero")){
            instructions.get(inst - 1).add(4, k);
            num2 = 0;
            }
              else  if (srcReg3.equalsIgnoreCase(reg[k].getName())) {
                    instructions.get(inst - 1).add(4, k);
                    rtReg = k;
                    rt.setText(k + "");
                    if (reg[k].getText().equals("0")) {
                        num2 = Integer.parseInt(JOptionPane.showInputDialog("Please enter the number in the 2nd source register "));
                        reg[k].setText(num2 + "");
                    } else {
                        num2 = Integer.parseInt(reg[k].getText());
                    }
                    data2Label.setText(num2 + "");
                    jLabel58.setText(num2 + "");
                    break;
                }
                DecToBin(num2, bin2);
            }
            String dstReg = JOptionPane.showInputDialog("Please enter the destination register: ");
            for (int i = 0; i < 29; i++) {
                if(dstReg.equalsIgnoreCase("$zero")){
          dstReg = JOptionPane.showInputDialog("You can't modify $zero, please enter another register: ");
                    if (dstReg.equalsIgnoreCase(reg[i].getName())) {
                    instructions.get(inst - 1).add(5, i);
                    rdReg = i;
                    writeReg.setText(i + "");
                    rd.setText(i + "");
                    for (int j = 0; j < 16; j++) {
                        bin3[j] = bin1[j] & bin2[j];
                    }
                    int z = BinToDec(bin3);
                    reg[i].setText(z + "");
                    break;
                }
                }
                else if (dstReg.equalsIgnoreCase(reg[i].getName())) {
                    instructions.get(inst - 1).add(5, i);
                    rdReg = i;
                    writeReg.setText(i + "");
                    rd.setText(i + "");
                    for (int j = 0; j < 16; j++) {
                        bin3[j] = bin1[j] & bin2[j];
                    }
                    int z = BinToDec(bin3);
                    reg[i].setText(z + "");
                    break;
                }
            } //int x=BinToDec(bin3); ALUResultLabel.setText(BinToDec(bin3)+""); writeData.setText(""+BinToDec(bin3)); regDstLabel.setText(""+BinToDec(bin3)); } }
        }
    }
    class or extends rFormat {

        int num1;
        int num2;
        int[] bin1 = new int[16];
        int[] bin2 = new int[16];
        int[] bin3 = new int[16];

        public or() {
            super();
            ALUControlLabel.setText("6");
            functionLabel.setText(37 + "");
        }
        public void DecToBin(int x, int[] bin) {
            for (int i = 0; i < 16; i++) {
                if (x == 0) {
                    bin[15 - i] = 0;
                } else {
                    bin[15 - i] = x % 2;
                }
                x /= 2;
            }
        }
        
        public int BinToDec(int[] Dec) {
            int y = 0;
            for (int i = 0; i < 16; i++) {
                if (Dec[15 - i] == 1) {
                    y = (int) (y + Math.pow(2, i));
                } else {
                    y += 0;
                }
            }
            return y;
        }

        public void orData() {
            jLabel27.setText(address + 4 + "");
            jLabel6.setText(address + 4 + "");
            String srcReg2 = JOptionPane.showInputDialog("Please enter the 1st source register: ");
            for (int i = 0; i < 29; i++) {
                if(srcReg2.equalsIgnoreCase("$zero")){
            instructions.get(inst - 1).add(3, i);
            num1 = 0;
            }
                else if (srcReg2.equalsIgnoreCase(reg[i].getName())) {
                    instructions.get(inst - 1).add(3, i);
                    rsReg = i;
                    rs.setText(i + "");
                    if (reg[i].getText().equals("0")) {
                        num1 = Integer.parseInt(JOptionPane.showInputDialog("Please enter the number in the 1st source register "));
                        reg[i].setText(num1 + "");
                    } else {
                        num1 = Integer.parseInt(reg[i].getText());
                    }
                    data1Label.setText(num1 + "");
                    break;
                }
                DecToBin(num1, bin1);
            }
            String srcReg3 = JOptionPane.showInputDialog("Please enter the 2nd source register: ");
            for (int k = 0; k < 29; k++) {
                if(srcReg2.equalsIgnoreCase("$zero")){
            instructions.get(inst - 1).add(4, k);
            num2 = 0;}
              else  if (srcReg3.equalsIgnoreCase(reg[k].getName())) {
                    instructions.get(inst - 1).add(4, k);
                    rtReg = k;
                    rt.setText(k + "");
                    if (reg[k].getText().equals("0")) {
                        num2 = Integer.parseInt(JOptionPane.showInputDialog("Please enter the number in the 2nd source register "));
                        reg[k].setText(num2 + "");
                    } else {
                        num2 = Integer.parseInt(reg[k].getText());
                    }
                    data2Label.setText(num2 + "");
                    jLabel58.setText(num2 + "");
                    break;
                }
                DecToBin(num2, bin2);
            }
            String dstReg = JOptionPane.showInputDialog("Please enter the destination register: ");
            for (int i = 0; i < 29; i++) {
                
           if(dstReg.equalsIgnoreCase("$zero")){
          dstReg = JOptionPane.showInputDialog("You can't modify $zero, please enter another register: ");
                    if (dstReg.equalsIgnoreCase(reg[i].getName())) {
                    instructions.get(inst - 1).add(5, i);
                    rdReg = i;
                    writeReg.setText(i + "");
                    rd.setText(i + "");
                    for (int j = 0; j < 16; j++) {
                        bin3[j] = bin1[j] | bin2[j];
                    }
                    int z = BinToDec(bin3);
                    reg[i].setText(z + "");
                    ALUResultLabel.setText(z + "");
                    writeData.setText("" + z);
                    regDstLabel.setText("" + z);
                    break;
                }
           }
           else if (dstReg.equalsIgnoreCase(reg[i].getName())) {
                    instructions.get(inst - 1).add(5, i);
                    rdReg = i;
                    writeReg.setText(i + "");
                    rd.setText(i + "");
                    for (int j = 0; j < 16; j++) {
                        bin3[j] = bin1[j] | bin2[j];
                    }
                    int z = BinToDec(bin3);
                    reg[i].setText(z + "");
                    ALUResultLabel.setText(z + "");
                    writeData.setText("" + z);
                    regDstLabel.setText("" + z);
                    break;
                }
            }
        }
    }
    class nor extends rFormat {

        int num1;
        int num2;
        ArrayList<Integer> bin1 = new ArrayList<Integer>();
        ArrayList<Integer> bin2 = new ArrayList<Integer>();
        ArrayList<Integer> or = new ArrayList<Integer>();
        public nor() {
            super();
            functionLabel.setText(39 + "");
        }

        public void DecToBin(int x,ArrayList<Integer> Binary) {
            int j;
            int[] bin = new int[16];
            for (int i = 0; i < 16; i++) {
                if (x == 0) {
                    bin[15 - i] = 0;
                } else {
                    bin[15 - i] = x % 2;
                }
                x /= 2;
            }
            for (j = 0 ; j < 16 ; j++)
            {
                if (bin[j] == 1)
                    break;
            }
            for (int k = j ; k < 16 ; k++)
            {
                Binary.add(bin[k]);
            }
        }

        public int BinToDec(ArrayList<Integer> Binary) {
            double dec = 0;
            int j = Binary.size() - 1;
            for (int i = 0; i < Binary.size(); i++,j--) {
                if (Binary.get(j) == 1)
                    dec += Math.pow(2, i);
            }
            return (int)dec;
        }
        public ArrayList OR(ArrayList<Integer> bin1, ArrayList<Integer> bin2,ArrayList<Integer> or)
        {
            if (bin1.size() > bin2.size())
            {
                for (int i = 0 ; i <= bin1.size()-bin2.size() ; i++)
                    bin2.add(i, 0);
                for (int j = 0 ; j < bin1.size() ; j++)
                    or.add(j,bin1.get(j) | bin2.get(j));
            }
            else 
            {
                for (int i = 0 ; i <= bin2.size()-bin1.size() ; i++)
                    bin1.add(i, 0);
                for (int j = 0 ; j < bin1.size() ; j++)
                    or.add(j,bin1.get(j) | bin2.get(j));
            }
            return or;
        }

        public ArrayList NOT(ArrayList<Integer> Binary) {
            for (int j = 0 ; j < Binary.size() ; j++)
            {
                if (Binary.get(j) == 0)
                {
                    Binary.remove(j);
                    Binary.add(j, 1);
                }
                else 
                {
                    Binary.remove(j);
                    Binary.add(j, 0);
                }
            }
            return Binary;
        }

        public void norData() {
            jLabel27.setText(address + 4 + "");
            jLabel6.setText(address + 4 + "");
            String srcReg2 = JOptionPane.showInputDialog("Please enter the 1st source register: ");
            for (int i = 0; i < 29; i++) {
                
            if(srcReg2.equalsIgnoreCase("$zero")){
            instructions.get(inst - 1).add(3, i);
            num1 = 0;
            }
            else    if (srcReg2.equalsIgnoreCase(reg[i].getName())) {
                    instructions.get(inst - 1).add(3, i);
                    rsReg = i;
                    rs.setText(i + "");
                    if (reg[i].getText().equals("0")) {
                        num1 = Integer.parseInt(JOptionPane.showInputDialog("Please enter the number in the 1st source register "));
                        reg[i].setText(num1 + "");
                    } else {
                        num1 = Integer.parseInt(reg[i].getText());
                    }
                    data1Label.setText(num1 + "");
                    break;
                }
            }
            DecToBin(num1,bin1);
            String srcReg3 = JOptionPane.showInputDialog("Please enter the 2nd source register: ");
            for (int k = 0; k < 29; k++) {
                 if(srcReg2.equalsIgnoreCase("$zero")){
            instructions.get(inst - 1).add(4, k);
            num2 = 0;
            }
             else   if (srcReg3.equalsIgnoreCase(reg[k].getName())) {
                    instructions.get(inst - 1).add(4, k);
                    rtReg = k;
                    rt.setText(k + "");
                    if (reg[k].getText().equals("0")) {
                        num2 = Integer.parseInt(JOptionPane.showInputDialog("Please enter the number in the 2nd source register "));
                        reg[k].setText(num2 + "");
                    } else {
                        num2 = Integer.parseInt(reg[k].getText());
                    }
                    data2Label.setText(num2 + "");
                    jLabel58.setText(num2 + "");
                    break;
                }
            }
            DecToBin(num2,bin2);
            String dstReg = JOptionPane.showInputDialog("Please enter the destination register: ");
            for (int i = 0; i < 29; i++) {
                if(dstReg.equalsIgnoreCase("$zero")){
          dstReg = JOptionPane.showInputDialog("You can't modify $zero, please enter another register: ");
             
                if (dstReg.equalsIgnoreCase(reg[i].getName())) {
                    instructions.get(inst - 1).add(5, i);
                    rdReg = i;
                    writeReg.setText(i + "");
                    rd.setText(i + "");
                    or = OR(bin1,bin2,or);
                    or = NOT(or);
                    int z;
                    z = BinToDec(or);
                    reg[i].setText(z + "");
                    ALUResultLabel.setText(z + "");
                    writeData.setText(z + "");
                    break;
                }
            }
              else   if (dstReg.equalsIgnoreCase(reg[i].getName())) {
                    instructions.get(inst - 1).add(5, i);
                    rdReg = i;
                    writeReg.setText(i + "");
                    rd.setText(i + "");
                    or = OR(bin1,bin2,or);
                    or = NOT(or);
                    int z;
                    z = BinToDec(or);
                    reg[i].setText(z + "");
                    ALUResultLabel.setText(z + "");
                    writeData.setText(z + "");
                    break;
                }
                
            }
        }
    }
    class jr extends rFormat {

        public jr() {
            super();
            ALUOpLabel.setText("X");
            ALUControlLabel.setText("X");
            memToRegLabel.setText("X");
            ALUSrcLabel.setText("X");
            jrLabel.setText("1");
            regWriteLabel.setText("0");
            regDstLabel.setText("X");
            rs.setText("31");
            data1Label.setText($ra.getText());
            jLabel6.setText($ra.getText());
            int i;
            int x1 = 0;
            for (i = 0; i < instructions.size(); i++) {
                x1 = Integer.parseInt($ra.getText());  //label
                int x = (int) instructions.get(i).get(1); //address
                if (x1 == x) {
                    break;
                }
            }
            for (int j = x1; j <= address; j += 4) {
                jumpBranch(instructions.get(i));
                JOptionPane.showConfirmDialog(null, "Press yes to go to the next instruction");
                i++;
            }
        }
    }

class iFormat extends formats
{
    protected int rsReg;
    protected int rtReg;
    protected int offImm;
    public iFormat(){
        super();
        ALUSrcLabel.setText(1+"");
    }   
}
 
class addi extends iFormat 
{
    int num1;
    int sum;
    public addi(){
        super();
        opCodeLabel.setText(8 + "");
        regWriteLabel.setText(1 + "");
        ALUControlLabel.setText(2 + ""); 
    }
    public void addiData(){
        jLabel27.setText(address + 4 + "");
        jLabel6.setText(address + 4 + ""); 
        String srcReg = JOptionPane.showInputDialog("Please enter the source register :");
        for (int i = 0 ; i < 29 ; i++)
        {
             if(srcReg.equalsIgnoreCase("$zero")){
            instructions.get(inst - 1).add(3, i);
            num1 = 0;
            }
          else  if (srcReg.equalsIgnoreCase(reg[i].getName()))
            { 
                instructions.get(inst - 1).add(3, i);
                this.rsReg = i;
                rs.setText(i+"");
                if(reg[i].getText().equals("0")){
                num1 = Integer.parseInt(JOptionPane.showInputDialog("Please enter the number in the source register :"));
                reg[i].setText(num1+"");
                }
                else {
                num1 = Integer.parseInt(reg[i].getText());
                }
                data1Label.setText(num1+"");
                break;
            }
        }
        this.offImm = Integer.parseInt(JOptionPane.showInputDialog("Please enter the immediate value :"));
        immediate16.setText(offImm+"");
        immediate32.setText(offImm+""); 
        String dstReg = JOptionPane.showInputDialog("Please enter the destination register :");
        for (int i = 0 ; i < 29 ; i++)
        {
            
           if(dstReg.equalsIgnoreCase("$zero")){
          dstReg = JOptionPane.showInputDialog("You can't modify $zero, please enter another register: ");
             
            if (dstReg.equalsIgnoreCase(reg[i].getName()))
            {
                instructions.get(inst - 1).add(4, i);
                this.rtReg = i;
                rt.setText(i+"");
                sum = this.offImm + num1;
                reg[i].setText(sum+"");
                break;
            }
           }
           else if (dstReg.equalsIgnoreCase(reg[i].getName()))
            {
                instructions.get(inst - 1).add(4, i);
                this.rtReg = i;
                rt.setText(i+"");
                sum = this.offImm + num1;
                reg[i].setText(sum+"");
                break;
            }
        }
        instructions.get(inst - 1).add(5, this.offImm);
        int sum = this.offImm + num1;
        if (sum == 0)
        zeroLabel.setText("1");
        writeReg.setText(rt.getText() + "");
        jLabel58.setText(this.offImm + "");
        ALUResultLabel.setText(sum + "");
        writeData.setText(sum + "");
        
    }
} 
class lw extends iFormat
{   
    public lw(){
        super();
        opCodeLabel.setText(35 + "");
        memReadLabel.setText(1 + "");
        memWriteLabel.setText(0 + "");
        memToRegLabel.setText(1 + "");
        regWriteLabel.setText(1 + "");
        ALUControlLabel.setText(2 + "");
        ALUSrcLabel.setText(1 + "");
    }
    public void lwData(){
        jLabel27.setText(address + 4 + "");
        jLabel6.setText(address + 4 + ""); 
        String srcReg = JOptionPane.showInputDialog("Please enter the base register :");
        int num;
        int sum;
        for (int i = 0 ; i < 29 ; i++)
        {
            if(srcReg.equalsIgnoreCase("$zero")){
            instructions.get(inst - 1).add(3, i);
            num = 0;
            }
          else  if (srcReg.equalsIgnoreCase(reg[i].getName()))
            {
                instructions.get(inst - 1).add(3, i);
                this.rsReg = i;
                rs.setText(i + "");
                if(reg[i].getText().equals("0")){
                    num = Integer.parseInt(JOptionPane.showInputDialog("Please initialise the value in the base register "));
                    reg[i].setText(num + "");
                }
                else {
                num = Integer.parseInt(reg[i].getText());
                } 
                data1Label.setText(num + "");
                break;
            }
        }
        this.offImm = Integer.parseInt(JOptionPane.showInputDialog("Please enter the offset :"));
        immediate16.setText(offImm + "");
        immediate32.setText(offImm + ""); 
        sum = Integer.parseInt(data1Label.getText()) + this.offImm;
        ALUResultLabel.setText(sum + "");
        String dstReg = JOptionPane.showInputDialog("Please enter the destination register :");
        for (int i = 0 ; i < 29 ; i++)
        {
            
           if(dstReg.equalsIgnoreCase("$zero")){
          dstReg = JOptionPane.showInputDialog("You can't modify $zero, please enter another register: ");
             
            if (dstReg.equalsIgnoreCase(reg[i].getName()))
            {
                instructions.get(inst - 1).add(4, i);
                this.rtReg = i;
                rt.setText(i + "");
                for (int j = 0; j < 26; j++) {
                    if (sum == Integer.parseInt(mem[j].getName())) {
                        if (mem[j].getText().equals("0")) {
                            int value = Integer.parseInt(JOptionPane.showInputDialog("Please enter a value to initialize the memory location: "));
                            mem[j].setText(value + "");
                        }

                        readDataLabel.setText(mem[j].getText());
                        reg[i].setText(mem[j].getText());
                        break;
                    }
                }
                break;
            }
           }
           else  if (dstReg.equalsIgnoreCase(reg[i].getName()))
            {
                instructions.get(inst - 1).add(4, i);
                this.rtReg = i;
                rt.setText(i + "");
                for (int j = 0; j < 26; j++) {
                    if (sum == Integer.parseInt(mem[j].getName())) {
                        if (mem[j].getText().equals("0")) {
                            int value = Integer.parseInt(JOptionPane.showInputDialog("Please enter a value to initialize the memory location: "));
                            mem[j].setText(value + "");
                        }

                        readDataLabel.setText(mem[j].getText());
                        reg[i].setText(mem[j].getText());
                        break;
                    }
                }
                break;
            }
        }
        instructions.get(inst - 1).add(5, this.offImm);
        writeReg.setText(rtReg + "");
        jLabel58.setText(this.offImm + "");
    }
}

class sw extends iFormat
{  
   public sw(){
        super(); 
        opCodeLabel.setText(43 + "");
        memWriteLabel.setText(1 + "");
        memToRegLabel.setText("X");
        ALUControlLabel.setText(2 + "");
        ALUSrcLabel.setText(1+"");
        regDstLabel.setText("X");
    }    
    public void swData(){
        jLabel27.setText(address + 4 + "");
        jLabel6.setText(address + 4 + ""); 
        String srcReg = JOptionPane.showInputDialog("Please enter the base register: ");
        int num;
        for (int i = 0 ; i < 29 ; i++)
        {
            if(srcReg.equalsIgnoreCase("$zero")){
            instructions.get(inst - 1).add(3, i);
            num = 0;
            }
          else  if (srcReg.equalsIgnoreCase(reg[i].getName()))
            {
                instructions.get(inst - 1).add(3, i);
                this.rsReg = i;
                rs.setText(i+"");
                if(reg[i].getText().equals("0")){
                    num = Integer.parseInt(JOptionPane.showInputDialog("Please initialize the value in the base register "));
                    reg[i].setText(num + "");
                }
                else {
                    num = Integer.parseInt(reg[i].getText());
                }
                data1Label.setText(num + "");
                break;
            }
        }  
        this.offImm = Integer.parseInt(JOptionPane.showInputDialog("Please enter the offset :"));
        immediate16.setText(offImm + "");
        immediate32.setText(offImm + "");
        int sum = Integer.parseInt(data1Label.getText()) + this.offImm;
        ALUResultLabel.setText(sum + "");
        String dstReg = JOptionPane.showInputDialog("Please enter the destination register :");
        for (int i = 0 ; i < 29 ; i++)
        {
            
           if(dstReg.equalsIgnoreCase("$zero")){
          dstReg = JOptionPane.showInputDialog("You can't modify $zero, please enter another register: ");
            
            if (dstReg.equalsIgnoreCase(reg[i].getName()))
            {
                instructions.get(inst - 1).add(4, i);
                this.rtReg = i;
                rt.setText(i+"");
                if(reg[i].getText().equals("0")){
                    num = Integer.parseInt(JOptionPane.showInputDialog("Please initialise the value in the destination register "));
                    reg[i].setText(num + "");
                }
                else {
                    num = Integer.parseInt(reg[i].getText());
                }
                data2Label.setText(num + "");
                for (int j = 0; j < 26; j++) {
                    if (sum == Integer.parseInt(mem[j].getName())) {
                       mem[j].setText(data2Label.getText());
                    }
                }
                break;
            }
           }
           else if (dstReg.equalsIgnoreCase(reg[i].getName()))
            {
                instructions.get(inst - 1).add(4, i);
                this.rtReg = i;
                rt.setText(i+"");
                if(reg[i].getText().equals("0")){
                    num = Integer.parseInt(JOptionPane.showInputDialog("Please initialise the value in the destination register "));
                    reg[i].setText(num + "");
                }
                else {
                    num = Integer.parseInt(reg[i].getText());
                }
                data2Label.setText(num + "");
                for (int j = 0; j < 26; j++) {
                    if (sum == Integer.parseInt(mem[j].getName())) {
                       mem[j].setText(data2Label.getText());
                    }
                }
                break;
            }
        }
        instructions.get(inst - 1).add(5, this.offImm);
        jLabel58.setText(this.offImm + "");
    }
}
class beq extends iFormat
{
    int num;
    int num1;
    public beq()
    {
        super();
        opCodeLabel.setText("4");
        branchLabel.setText("1");
        ALUOpLabel.setText("1");
        ALUControlLabel.setText("6");
        regDstLabel.setText("X");
        memToRegLabel.setText("X");  
        ALUSrcLabel.setText("0");
    }
    public void beqData()
    {
        String srcReg = JOptionPane.showInputDialog("Please enter the 1st source register: ");
        for (int i = 0 ; i < 29 ; i++)
        {
            
            if(srcReg.equalsIgnoreCase("$zero")){
            instructions.get(inst - 1).add(3, 0);
            num = 0;
            }
          else  if (srcReg.equalsIgnoreCase(reg[i].getName()))
            {
                instructions.get(inst - 1).add(3, i);
                this.rsReg = i;
                rs.setText(i+"");
                if(reg[i].getText().equals("0")){
                    num = Integer.parseInt(JOptionPane.showInputDialog("Please initialize the value in the 1st source register "));
                    reg[i].setText(num + "");
                }
                else {
                    num = Integer.parseInt(reg[i].getText());
                }
                data1Label.setText(num + "");
                break;
            }
        }
        
        String srcReg1 = JOptionPane.showInputDialog("Please enter the 2nd source register: ");
        for (int i = 0 ; i < 29 ; i++)
        {
            
            if(srcReg1.equalsIgnoreCase("$zero")){
            instructions.get(inst - 1).add(4, 0);
            num1 = 0;
            }
           else if (srcReg1.equalsIgnoreCase(reg[i].getName()))
            {
                instructions.get(inst - 1).add(4, i);
                this.rtReg = i;
                rt.setText(i+"");
                if(reg[i].getText().equals("0")){
                    num1 = Integer.parseInt(JOptionPane.showInputDialog("Please initialize the value in the 2nd source register "));
                    reg[i].setText(num1 + "");
                }
                else {
                    num1 = Integer.parseInt(reg[i].getText());
                }
                data2Label.setText(num1 + "");
                writeReg.setText(num1 + "");
                break;
            }
        }
        String label = JOptionPane.showInputDialog("Please enter the label name :");
        instructions.get(inst - 1).add(5, label);
        int result = num - num1;
        int i;
        int x = 0;
        if (result == 0)
        {
            zeroLabel.setText("1");
            ANDbeq.setText("1");
            ORLabel.setText("1");
            for (i = 0 ; i < instructions.size() ;i++)
            {
                String s = (String)instructions.get(i).get(0);
                x = (int)instructions.get(i).get(1);
                if (s.equalsIgnoreCase(label))
                {
                    immediate16.setText((x - address - 4)/4 + "");
                    immediate32.setText((x - address - 4)/4 + "");
                    shiftLeft2Label.setText(x- address - 4 + "");
                    jLabel10.setText(x + "");
                    jLabel27.setText(x + "");
                    jLabel6.setText(x + "");
                    break;
                }
            }
            for (int j = x ; j <= address ; j+=4)
            {
                jumpBranch(instructions.get(i));
                JOptionPane.showMessageDialog(null, "Press OK to go to the next instruction");
                i++;
            }
        }
        else 
        {
            ALUResultLabel.setText(result + "");
            jLabel27.setText(address + 4 + "");
            jLabel6.setText(address + 4 + ""); 
        }
    }
}
class bne extends iFormat 
{
    int num;
    int num1;
    public bne()
    {
        super();
        opCodeLabel.setText("5");
        bneLabel.setText("1");
        ALUOpLabel.setText("1");
        ALUControlLabel.setText("6");
        regDstLabel.setText("X");
        memToRegLabel.setText("X");
        ALUSrcLabel.setText("0");
    }
    public void bneData()
    {
        String srcReg = JOptionPane.showInputDialog("Please enter the 1st source register: ");
        for (int i = 0 ; i < 29 ; i++)
        {
            if(srcReg.equalsIgnoreCase("$zero")){
            instructions.get(inst - 1).add(3, i);
            num = 0;
            }
          else  if (srcReg.equalsIgnoreCase(reg[i].getName()))
            {
                instructions.get(inst - 1).add(3, i);
                this.rsReg = i;
                rs.setText(i+"");
                if(reg[i].getText().equals("0")){
                    num = Integer.parseInt(JOptionPane.showInputDialog("Please initialize the value in the 1st source register "));
                    reg[i].setText(num + "");
                }
                else {
                    num = Integer.parseInt(reg[i].getText());
                }
                data1Label.setText(num + "");
                break;
            }
        }
        String srcReg1 = JOptionPane.showInputDialog("Please enter the 2nd source register: ");
        for (int i = 0 ; i < 29 ; i++)
        {
             if(srcReg1.equalsIgnoreCase("$zero")){
            instructions.get(inst - 1).add(4, i);
            num1 = 0;
            }
           else if (srcReg1.equalsIgnoreCase(reg[i].getName()))
            {
                instructions.get(inst - 1).add(4, i);
                this.rtReg = i;
                rt.setText(i+"");
                if(reg[i].getText().equals("0")){
                    num1 = Integer.parseInt(JOptionPane.showInputDialog("Please initialize the value in the 2nd source register "));
                    reg[i].setText(num1 + "");
                }
                else {
                    num1 = Integer.parseInt(reg[i].getText());
                }
                data2Label.setText(num1 + "");
                writeReg.setText(num1 + "");
                break;
            }
        }
        String label = JOptionPane.showInputDialog("Please enter the label name :");
        instructions.get(inst - 1).add(5, label);
        int result = num - num1;
        int x = 0;
        int i;
        if (result != 0)
        {
            ALUResultLabel.setText(result + "");
            ANDbne.setText("1");
            ORLabel.setText("1");
            for (i = 0 ; i < instructions.size() ;i++)
            {
                String s = (String)instructions.get(i).get(0);
                x = (int)instructions.get(i).get(1);
                if (s.equalsIgnoreCase(label))
                {
                    immediate16.setText((x - address - 4)/4 + "");
                    immediate32.setText((x - address - 4)/4 + "");
                    shiftLeft2Label.setText(x- address - 4 + "");
                    jLabel10.setText(x + "");
                    jLabel27.setText(x + "");
                    jLabel6.setText(x + "");
                    break;
                }
            }
            for (int j = x ; j <= address ; j+=4)
            {
                jumpBranch(instructions.get(i));
                JOptionPane.showMessageDialog(null, "Press OK to go to the next instruction");
                i++;
            }
        }
        else 
        {
            zeroLabel.setText("1");
            jLabel27.setText(address + 4 + "");
            jLabel6.setText(address + 4 + ""); 
        }
    }
}
    class slti extends iFormat {

        int num1;
        int num2;

        public slti() {
            super();
            opCodeLabel.setText("10");
            ALUControlLabel.setText("2");
        }

        public void sltiData() {
            jLabel27.setText(address + 4 + "");
            jLabel6.setText(address + 4 + "");
            String srcReg = JOptionPane.showInputDialog("Please enter the source register: ");
            for (int i = 0; i < 29; i++) {
                  if(srcReg.equalsIgnoreCase("$zero")){
            instructions.get(inst - 1).add(3, i);
            num1 = 0;
            }
             else   if (srcReg.equalsIgnoreCase(reg[i].getName())) {
                    instructions.get(inst - 1).add(3, i);
                    rsReg = i;
                    rs.setText(i + "");
                    if (reg[i].getText().equals("0")) {
                        num1 = Integer.parseInt(JOptionPane.showInputDialog("Please enter the number in the source register "));
                        reg[i].setText(num1 + "");
                    } else {
                        num1 = Integer.parseInt(reg[i].getText());
                    }
                    data1Label.setText(num1 + "");
                    break;
                }
            }
        
            offImm = Integer.parseInt(JOptionPane.showInputDialog("Please enter a number: "));
            immediate16.setText(offImm + "");
            immediate32.setText(offImm + "");
            String dstReg = JOptionPane.showInputDialog("Please enter the destination register: ");
            for (int i = 0; i < 29; i++) {
                if(dstReg.equalsIgnoreCase("$zero")){
          dstReg = JOptionPane.showInputDialog("You can't modify $zero, please enter another register: ");
             
                if (dstReg.equalsIgnoreCase(reg[i].getName())) {
                    instructions.get(inst - 1).add(4, i);
                    rtReg = i;
                    rt.setText(i + "");
                    if (num1 < offImm) {
                        num2 = 1;
                    } else {
                        num2 = 0;
                    }
                    reg[i].setText(num2 + "");
                }
                }
                
              else  if (dstReg.equalsIgnoreCase(reg[i].getName())) {
                    instructions.get(inst - 1).add(4, i);
                    rtReg = i;
                    rt.setText(i + "");
                    if (num1 < offImm) {
                        num2 = 1;
                    } else {
                        num2 = 0;
                    }
                    reg[i].setText(num2 + "");
                }
            }
            writeReg.setText(rtReg + "");
            jLabel58.setText(offImm + "");
            ALUResultLabel.setText(num2 + "");
            regDstLabel.setText(num2 + "");
            writeData.setText(num2 + "");
            instructions.get(inst - 1).add(5, offImm);
        }
    }
    class sltui extends iFormat {

        int num1;
        int num2;

        public sltui() {
            super();
            opCodeLabel.setText("11");
            ALUControlLabel.setText("2");
        }

        public void sltuiData() {
            jLabel27.setText(address + 4 + "");
            jLabel6.setText(address + 4 + "");
            String srcReg = JOptionPane.showInputDialog("Please enter the source register: ");
            for (int i = 0; i < 29; i++) {
                    if(srcReg.equalsIgnoreCase("$zero")){
            instructions.get(inst - 1).add(3, i);
            num1 = 0;
            }
             else   if (srcReg.equalsIgnoreCase(reg[i].getName())) {
                    instructions.get(inst - 1).add(3, i);
                    rsReg = i;
                    rs.setText(i + "");
                    if (reg[i].getText().equals("0")) {
                        num1 = Integer.parseInt(JOptionPane.showInputDialog("Please enter the number in the source register "));
                        reg[i].setText(num1 + "");
                    } else {
                        num1 = Integer.parseInt(reg[i].getText());
                    }
                    data1Label.setText(num1 + "");
                    num1 = Math.abs(num1);
                    break;
                }
            }
            offImm = Integer.parseInt(JOptionPane.showInputDialog("Please enter a number: "));
            immediate16.setText(offImm + "");
            immediate32.setText(offImm + "");
            jLabel58.setText(offImm + "");
            offImm = Math.abs(offImm);

            String dstReg = JOptionPane.showInputDialog("Please enter the destination register: ");
            for (int i = 0; i < 29; i++) {
                
           if(dstReg.equalsIgnoreCase("$zero")){
          dstReg = JOptionPane.showInputDialog("You can't modify $zero, please enter another register: ");
            
                if (dstReg.equalsIgnoreCase(reg[i].getName())) {
                    instructions.get(inst - 1).add(4, i);
                    rtReg = i;
                    rt.setText(i + "");
                    if (num1 < offImm) {
                        num2 = 1;
                    } else {
                        num2 = 0;
                    }
                    reg[i].setText(num2 + "");
                    break;
                }
           }
           else if (dstReg.equalsIgnoreCase(reg[i].getName())) {
                    instructions.get(inst - 1).add(4, i);
                    rtReg = i;
                    rt.setText(i + "");
                    if (num1 < offImm) {
                        num2 = 1;
                    } else {
                        num2 = 0;
                    }
                    reg[i].setText(num2 + "");
                    break;
                }
            }
            instructions.get(inst - 1).add(5, offImm);
            writeReg.setText(rtReg + "");
            ALUResultLabel.setText(num2 + "");
            regDstLabel.setText(num2 + "");
            writeData.setText(num2 + "");
        }
    }
abstract class jFormat extends formats
{
    public jFormat ()
    {
        super();
        jumpLabel.setText("1");
        ALUOpLabel.setText("X");
        ALUControlLabel.setText("X");
        ALUSrcLabel.setText("X");  
    }
}

class j extends jFormat
{
    public j ()
    {
        super ();
        opCodeLabel.setText("2");
        regDstLabel.setText("X");
        memToRegLabel.setText("X");
    }
    public void jData ()
    {
        int i;
        int x = 0;
        for (i = 0 ; i < instructions.size() ; i++)
        {
            String s = (String)instructions.get(i).get(0);
            x = (int)instructions.get(i).get(1);
            if (s.contentEquals(JOptionPane.showInputDialog("Please enter the name of the label :")));
            {
                jLabel8.setText(x / 4 + "");
                jLabel7.setText(x + "");
                jLabel7.setText(x + "");
                jLabel6.setText(x + "");
                break;
            }
            
        }
        for (int j = x ; j <= address ; j+=4)
            {
                jumpBranch(instructions.get(i));
                JOptionPane.showMessageDialog(null, "Press OK to go to the next instruction");
                i++;
            }
    }
}
class jal extends jFormat
{
    public jal ()
    {
        regWriteLabel.setText("1");
        opCodeLabel.setText("3");
        rd.setText("31");
        writeReg.setText("31");
        regDstLabel.setText("2");
        memToRegLabel.setText("2");
        $ra.setText(address + 4 + "");
    }
    public void jalData ()
    {
        int i;
        int x = 0;
        for (i = 0 ; i < instructions.size() ; i++)
        {
            String s = (String)instructions.get(i).get(0);
            x = (int)instructions.get(i).get(1);
            if (s.contentEquals(JOptionPane.showInputDialog("Please enter the name of the label :")));
            {
                jLabel8.setText(x / 4 + "");
                jLabel7.setText(x + "");
                jLabel7.setText(x + "");
                jLabel6.setText(x + "");
                break;
            }
        }
        for (int j = x ; j <= address ; j+=4)
        {
            jumpBranch(instructions.get(i));
            JOptionPane.showMessageDialog(null, "Press OK to go to the next instruction");
            i++;
        }
    }
}   
    public void jumpBranch (ArrayList inst)
    {
        clockCycles++;
        clockCyclesLabel.setText(clockCycles + "");
        String lbl = (String)inst.get(0);
        int address1 = (int)inst.get(1); //address
        String type = (String)inst.get(2);
        int rs1 = (int)inst.get(3);
        int rt1 = (int)inst.get(4);
        int num;
        formats i;
        switch(type)
        {
            case "add" :
            {
                int rdOff = (int)inst.get(5);
                i = new add ();
                pcLabel.setText(address1 + "");
                $pcLabel.setText(address1 + "");
                jLabel5.setText(address1 + 4 + "");
                jLabel27.setText(address1 + 4 + "");
                jLabel6.setText(address1 + 4 + ""); 
                rs.setText(rs1 + "");
                rt.setText(rt1 + "");
                rd.setText(rdOff + "");
                writeReg.setText(rdOff + "");
                data1Label.setText(reg[rs1].getText() + "");
                data2Label.setText(reg[rt1].getText() + "");
                jLabel58.setText(reg[rt1].getText() + "");
                num = Integer.parseInt(reg[rs1].getText()) + Integer.parseInt(reg[rt1].getText());
                ALUResultLabel.setText(num + "");
                reg[rdOff].setText(num + "");
                if (num == 0)
                    zeroLabel.setText(1 + "");
                writeData.setText(num + "");
            }
            break;
            case "sub" :
            {
                int rdOff = (int)inst.get(5);
                i = new sub ();
                pcLabel.setText(address1 + "");
                $pcLabel.setText(address1 + "");
                jLabel5.setText(address1 + 4 + "");
                jLabel27.setText(address1 + 4 + "");
                jLabel6.setText(address1 + 4 + ""); 
                rs.setText(rs1 + "");
                rt.setText(rt1 + "");
                rd.setText(rdOff + "");
                writeReg.setText(rdOff + "");
                data1Label.setText(reg[rs1].getText() + "");
                data2Label.setText(reg[rt1].getText() + "");
                jLabel58.setText(reg[rt1].getText() + "");
                num = Integer.parseInt(reg[rs1].getText()) - Integer.parseInt(reg[rt1].getText());
                ALUResultLabel.setText(num + "");
                reg[rdOff].setText(num + "");
                if (num == 0)
                    zeroLabel.setText(1 + "");
                writeData.setText(num + "");   
            }
            break;
            case "addi" :
            {
                int rdOff = (int)inst.get(5);
                i = new addi ();
                pcLabel.setText(address1 + "");
                $pcLabel.setText(address1 + "");
                jLabel5.setText(address1 + 4 + "");
                jLabel27.setText(address1 + 4 + "");
                jLabel6.setText(address1 + 4 + ""); 
                rs.setText(rs1 + "");
                rt.setText(rt1 + "");
                immediate16.setText(rdOff + "");
                immediate32.setText(rdOff + "");
                writeReg.setText(rt1 + "");
                data1Label.setText(reg[rs1].getText() + "");
                jLabel58.setText(rdOff + "");
                num = Integer.parseInt(reg[rs1].getText()) + rdOff;
                ALUResultLabel.setText(num + "");
                reg[rt1].setText(num + "");
                if (num == 0)
                    zeroLabel.setText(1 + "");
                writeData.setText(num + "");
            }
            break;
            case "lw" :
            {
                int rdOff = (int)inst.get(5);
                i = new lw ();
                pcLabel.setText(address1 + "");
                $pcLabel.setText(address1 + "");
                jLabel5.setText(address1 + 4 + "");
                jLabel27.setText(address1 + 4 + "");
                jLabel6.setText(address1 + 4 + ""); 
                rs.setText(rs1 + "");
                rt.setText(rt1 + "");
                immediate16.setText(rdOff + "");
                immediate32.setText(rdOff + "");
                writeReg.setText(rt1 + "");
                data1Label.setText(reg[rs1].getText() + "");
                jLabel58.setText(rdOff + "");
                num = Integer.parseInt(reg[rs1].getText()) + rdOff;
                ALUResultLabel.setText(num + "");
                
                if (num == 0)
                    zeroLabel.setText(1 + "");
                for (int j = 0 ; j < 26 ; j++)
                {
                    if (Integer.parseInt(mem[j].getName()) == num)
                    {
                        readDataLabel.setText(mem[j].getText());
                        writeData.setText(mem[j].getText());
                        reg[rt1].setText(mem[j].getText());
                    }
                }
            }
            break;
            case "sw" :
            {
                int rdOff = (int)inst.get(5);
                i = new sw ();
                pcLabel.setText(address1 + "");
                $pcLabel.setText(address1 + "");
                jLabel5.setText(address1 + 4 + "");
                jLabel27.setText(address1 + 4 + "");
                jLabel6.setText(address1 + 4 + ""); 
                rs.setText(rs1 + "");
                rt.setText(rt1 + "");
                immediate16.setText(rdOff + "");
                immediate32.setText(rdOff + "");
                data1Label.setText(reg[rs1].getText() + "");
                data2Label.setText(reg[rt1].getText() + "");
                jLabel58.setText(rdOff + "");
                num = Integer.parseInt(reg[rs1].getText()) + rdOff;
                ALUResultLabel.setText(num + "");
                if (num == 0)
                    zeroLabel.setText(1 + "");
                for (int j = 0 ; j < 26 ; j++)
                {
                    if (Integer.parseInt(mem[j].getName()) == num)
                    {
                        mem[j].setText(reg[rt1].getText() + "");
                    }
                }
            }
            break;
            case "sll" :
            {
                int rdOff = (int)inst.get(5);
                sll i1 = new sll ();
                pcLabel.setText(address1 + "");
                $pcLabel.setText(address1 + "");
                jLabel5.setText(address1 + 4 + "");
                jLabel27.setText(address1 + 4 + "");
                jLabel6.setText(address1 + 4 + ""); 
                rt.setText(rs1 + "");
                shamtLabel.setText(rt1 + "");
                rd.setText(rdOff + "");
                writeReg.setText(rdOff + "");
                data2Label.setText(reg[rs1].getText() + "");
                jLabel58.setText(reg[rs1].getText() + "");
                num = (int) ( Integer.parseInt(reg[rs1].getText()) * (Math.pow(2, rt1)));
                ALUResultLabel.setText(num + "");
                reg[rdOff].setText(num + "");
                if (num == 0)
                    zeroLabel.setText(1 + "");
                writeData.setText(num + ""); 
            }
            break;
            case "and" :
            {
                int rdOff = (int)inst.get(5);
                and i1 = new and ();
                pcLabel.setText(address1 + "");
                $pcLabel.setText(address1 + "");
                jLabel5.setText(address1 + 4 + "");
                jLabel27.setText(address1 + 4 + "");
                jLabel6.setText(address1 + 4 + ""); 
                rs.setText(rs1 + "");
                rt.setText(rt1 + "");
                rd.setText(rdOff + "");
                writeReg.setText(rdOff + "");
                data1Label.setText(reg[rs1].getText() + "");
                i1.DecToBin(Integer.parseInt(reg[rs1].getText()), i1.bin1);
                data2Label.setText(reg[rt1].getText() + "");
                i1.DecToBin(Integer.parseInt(reg[rt1].getText()), i1.bin2);
                jLabel58.setText(reg[rt1].getText() + "");
                for (int j = 0; j < 16; j++) {
                        i1.bin3[j] = i1.bin1[j] & i1.bin2[j];
                    }
                num = i1.BinToDec(i1.bin3);
                ALUResultLabel.setText(num + "");
                reg[rdOff].setText(num + "");
                if (num == 0)
                    zeroLabel.setText(1 + "");
                writeData.setText(num + "");   
            }
            break;
            case "or" :
            {
                int rdOff = (int)inst.get(5);
                or i1 = new or ();
                pcLabel.setText(address1 + "");
                $pcLabel.setText(address1 + "");
                jLabel5.setText(address1 + 4 + "");
                jLabel27.setText(address1 + 4 + "");
                jLabel6.setText(address1 + 4 + ""); 
                rs.setText(rs1 + "");
                rt.setText(rt1 + "");
                rd.setText(rdOff + "");
                writeReg.setText(rdOff + "");
                data1Label.setText(reg[rs1].getText() + "");
                i1.DecToBin(Integer.parseInt(reg[rs1].getText()), i1.bin1);
                data2Label.setText(reg[rt1].getText() + "");
                i1.DecToBin(Integer.parseInt(reg[rt1].getText()), i1.bin2);
                jLabel58.setText(reg[rt1].getText() + "");
                for (int j = 0; j < 16; j++) {
                        i1.bin3[j] = i1.bin1[j] | i1.bin2[j];
                    }
                num = i1.BinToDec(i1.bin3);
                ALUResultLabel.setText(num + "");
                reg[rdOff].setText(num + "");
                if (num == 0)
                    zeroLabel.setText(1 + "");
                writeData.setText(num + ""); 
            }
            break;
            case "nor" :
            {
                int rdOff = (int)inst.get(5);
                nor i1 = new nor ();
                pcLabel.setText(address1 + "");
                $pcLabel.setText(address1 + "");
                jLabel5.setText(address1 + 4 + "");
                jLabel27.setText(address1 + 4 + "");
                jLabel6.setText(address1 + 4 + ""); 
                rs.setText(rs1 + "");
                rt.setText(rt1 + "");
                rd.setText(rdOff + "");
                writeReg.setText(rdOff + "");
                data1Label.setText(reg[rs1].getText() + "");
                i1.DecToBin(Integer.parseInt(reg[rs1].getText()), i1.bin1);
                data2Label.setText(reg[rt1].getText() + "");
                i1.DecToBin(Integer.parseInt(reg[rt1].getText()), i1.bin2);
                jLabel58.setText(reg[rt1].getText() + "");
                i1.OR(i1.bin1, i1.bin2, i1.or);
                i1.NOT(i1.or);
                num = i1.BinToDec(i1.or);
                ALUResultLabel.setText(num + "");
                reg[rdOff].setText(num + "");
                if (num == 0)
                    zeroLabel.setText(1 + "");
                writeData.setText(num + ""); 
            }
            break;
            case "beq" :
            {
                i = new beq();
                pcLabel.setText(address1 + "");
                $pcLabel.setText(address1 + "");
                jLabel5.setText(address1 + 4 + "");
                jLabel27.setText(address1 + 4 + "");
                jLabel6.setText(address1 + 4 + ""); 
                rs.setText(rs1 + "");
                rt.setText(rt1 + "");
                data1Label.setText(reg[rs1].getText() + "");
                data2Label.setText(reg[rt1].getText() + "");
                jLabel58.setText(reg[rt1].getText() + "");
                num = Integer.parseInt(reg[rs1].getText()) - Integer.parseInt(reg[rt1].getText());
                int x = 0;
                int j;
                String label = (String)inst.get(5);
                if (num == 0)
                {
                    zeroLabel.setText("1");
                    ANDbeq.setText("1");
                    ORLabel.setText("1");
                    for (j = 0 ; j < instructions.size() ;j++)
                    {
                        String s = (String)instructions.get(j).get(0);
                        x = (int)instructions.get(j).get(1);
                        if (s.equalsIgnoreCase(label))
                        {
                            immediate16.setText((x - address1 - 4)/4 + "");
                            immediate32.setText((x - address1 - 4)/4 + "");
                            shiftLeft2Label.setText(x- address1 - 4 + "");
                            jLabel10.setText(x + "");
                            jLabel27.setText(x + "");
                            jLabel6.setText(x + "");
                            break;
                        }
                    }
                    for (int k = x ; k <= address1 ; k+=4)
                    {
                        jumpBranch(instructions.get(j));
                        JOptionPane.showMessageDialog(null, "Press OK to go to the next instruction");
                        j++;
                    }
                }
                
                else 
                {
                    ALUResultLabel.setText(num + "");
                    jLabel27.setText(address + 4 + "");
                    jLabel6.setText(address + 4 + ""); 
                }
            }
            break;
            case "bne" :
            {
                i = new bne();
                pcLabel.setText(address1 + "");
                $pcLabel.setText(address1 + "");
                jLabel5.setText(address1 + 4 + "");
                jLabel27.setText(address1 + 4 + "");
                jLabel6.setText(address1 + 4 + ""); 
                rs.setText(rs1 + "");
                rt.setText(rt1 + "");
                data1Label.setText(reg[rs1].getText() + "");
                data2Label.setText(reg[rt1].getText() + "");
                jLabel58.setText(reg[rt1].getText() + "");
                num = Integer.parseInt(reg[rs1].getText()) - Integer.parseInt(reg[rt1].getText());
                int x = 0;
                int j;
                if (num != 0)
                {
                    ALUResultLabel.setText(num + "");
                    ANDbne.setText("1");
                    ORLabel.setText("1");
                    for (j = 0 ; j < instructions.size() ;j++)
                    {
                        String s = (String)instructions.get(j).get(0);
                        x = (int)instructions.get(j).get(1);
                        if (s.equalsIgnoreCase(lbl))
                        {
                            immediate16.setText((x - address - 4)/4 + "");
                            immediate32.setText((x - address - 4)/4 + "");
                            shiftLeft2Label.setText(x- address - 4 + "");
                            jLabel10.setText(x + "");
                            jLabel27.setText(x + "");
                            jLabel6.setText(x + "");
                            jumpBranch(instructions.get(j));
                        }
                    }
                    for (int k = x ; k <= address1 ; k+=4)
                    {
                        jumpBranch(instructions.get(j));
                        JOptionPane.showMessageDialog(null, "Press OK to go to the next instruction");
                        j++;
                    }
                }
                else 
                {
                    zeroLabel.setText("1");
                    jLabel27.setText(address + 4 + "");
                    jLabel6.setText(address + 4 + ""); 
                }
            }
            break;
            case "slt" :
            {
                int rdOff = (int)inst.get(5);
                i = new add ();
                pcLabel.setText(address1 + "");
                $pcLabel.setText(address1 + "");
                jLabel5.setText(address1 + 4 + "");
                jLabel27.setText(address1 + 4 + "");
                jLabel6.setText(address1 + 4 + ""); 
                rs.setText(rs1 + "");
                rt.setText(rt1 + "");
                rd.setText(rdOff + "");
                writeReg.setText(rdOff + "");
                data1Label.setText(reg[rs1].getText() + "");
                data2Label.setText(reg[rt1].getText() + "");
                jLabel58.setText(reg[rt1].getText() + "");
                if(Integer.parseInt(reg[rs1].getText()) < Integer.parseInt(reg[rt1].getText()))
                    num = 1;
                else
                    num = 0;
                ALUResultLabel.setText(num + "");
                reg[rdOff].setText(num + "");
                if (num == 0)
                    zeroLabel.setText(1 + "");
                writeData.setText(num + "");
            }
            break;
            case "slti" :
            {
                int rdOff = (int)inst.get(5);
                i = new slti ();
                pcLabel.setText(address1 + "");
                $pcLabel.setText(address1 + "");
                jLabel5.setText(address1 + 4 + "");
                jLabel27.setText(address1 + 4 + "");
                jLabel6.setText(address1 + 4 + ""); 
                rs.setText(rs1 + "");
                rt.setText(rt1 + "");
                immediate16.setText(rdOff + "");
                immediate32.setText(rdOff + "");
                writeReg.setText(rt1 + "");
                data1Label.setText(reg[rs1].getText() + "");
                jLabel58.setText(rdOff + "");
                if (Integer.parseInt(reg[rs1].getText()) < rdOff) {
                        num = 1;
                    } else {
                        num = 0;
                    }
                ALUResultLabel.setText(num + "");
                reg[rt1].setText(num + "");
                if (num == 0)
                    zeroLabel.setText(1 + "");
                writeData.setText(num + "");
            }
            break;
            case "sltu" :
            {
                int rdOff = (int)inst.get(5);
                i = new sltu ();
                pcLabel.setText(address1 + "");
                $pcLabel.setText(address1 + "");
                jLabel5.setText(address1 + 4 + "");
                jLabel27.setText(address1 + 4 + "");
                jLabel6.setText(address1 + 4 + ""); 
                rs.setText(rs1 + "");
                rt.setText(rt1 + "");
                rd.setText(rdOff + "");
                writeReg.setText(rdOff + "");
                data1Label.setText(reg[rs1].getText() + "");
                data2Label.setText(reg[rt1].getText() + "");
                jLabel58.setText(reg[rt1].getText() + "");
                if(Math.abs(Integer.parseInt(reg[rs1].getText())) < Math.abs(Integer.parseInt(reg[rt1].getText())))
                    num = 1;
                else
                    num = 0;
                ALUResultLabel.setText(num + "");
                reg[rdOff].setText(num + "");
                if (num == 0)
                    zeroLabel.setText(1 + "");
                writeData.setText(num + "");
            }
            break;
            case "sltui" :
            {
                int rdOff = (int)inst.get(5);
                i = new sltui ();
                pcLabel.setText(address1 + "");
                $pcLabel.setText(address1 + "");
                jLabel5.setText(address1 + 4 + "");
                jLabel27.setText(address1 + 4 + "");
                jLabel6.setText(address1 + 4 + ""); 
                rs.setText(rs1 + "");
                rt.setText(rt1 + "");
                immediate16.setText(rdOff + "");
                immediate32.setText(rdOff + "");
                writeReg.setText(rt1 + "");
                data1Label.setText(reg[rs1].getText() + "");
                jLabel58.setText(rdOff + "");
                if (Math.abs(Integer.parseInt(reg[rs1].getText())) < Math.abs(rdOff)) {
                        num = 1;
                    } else {
                        num = 0;
                    }
                ALUResultLabel.setText(num + "");
                reg[rt1].setText(num + "");
                if (num == 0)
                    zeroLabel.setText(1 + "");
                writeData.setText(num + "");
            }
            break;
        }           
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel $a0;
    private javax.swing.JLabel $a1;
    private javax.swing.JLabel $a2;
    private javax.swing.JLabel $a3;
    private javax.swing.JLabel $at;
    private javax.swing.JLabel $pc;
    private javax.swing.JLabel $pcLabel;
    private javax.swing.JLabel $ra;
    private javax.swing.JLabel $s0;
    private javax.swing.JLabel $s1;
    private javax.swing.JLabel $s2;
    private javax.swing.JLabel $s3;
    private javax.swing.JLabel $s4;
    private javax.swing.JLabel $s5;
    private javax.swing.JLabel $s6;
    private javax.swing.JLabel $s7;
    private javax.swing.JLabel $sp;
    private javax.swing.JLabel $t0;
    private javax.swing.JLabel $t1;
    private javax.swing.JLabel $t2;
    private javax.swing.JLabel $t3;
    private javax.swing.JLabel $t4;
    private javax.swing.JLabel $t5;
    private javax.swing.JLabel $t6;
    private javax.swing.JLabel $t7;
    private javax.swing.JLabel $t8;
    private javax.swing.JLabel $t9;
    private javax.swing.JLabel $v0;
    private javax.swing.JLabel $v1;
    private javax.swing.JLabel $zero;
    private javax.swing.JLabel ALUControlLabel;
    private javax.swing.JLabel ALUOpLabel;
    private javax.swing.JLabel ALUResultLabel;
    private javax.swing.JLabel ALUSrcLabel;
    private javax.swing.JLabel ANDbeq;
    private javax.swing.JLabel ANDbne;
    private javax.swing.JLabel ORLabel;
    private javax.swing.JLabel a0;
    private javax.swing.JLabel a1;
    private javax.swing.JLabel a2;
    private javax.swing.JLabel a3;
    private javax.swing.JLabel address0;
    private javax.swing.JLabel address100;
    private javax.swing.JLabel address12;
    private javax.swing.JLabel address16;
    private javax.swing.JLabel address20;
    private javax.swing.JLabel address24;
    private javax.swing.JLabel address28;
    private javax.swing.JLabel address32;
    private javax.swing.JLabel address36;
    private javax.swing.JLabel address4;
    private javax.swing.JLabel address40;
    private javax.swing.JLabel address44;
    private javax.swing.JLabel address48;
    private javax.swing.JLabel address52;
    private javax.swing.JLabel address56;
    private javax.swing.JLabel address60;
    private javax.swing.JLabel address64;
    private javax.swing.JLabel address68;
    private javax.swing.JLabel address72;
    private javax.swing.JLabel address76;
    private javax.swing.JLabel address8;
    private javax.swing.JLabel address80;
    private javax.swing.JLabel address84;
    private javax.swing.JLabel address88;
    private javax.swing.JLabel address92;
    private javax.swing.JLabel address96;
    private javax.swing.JLabel at;
    private javax.swing.JLabel bneLabel;
    private javax.swing.JLabel branchLabel;
    private javax.swing.JLabel clockCyclesLabel;
    private javax.swing.JLabel data1Label;
    private javax.swing.JLabel data2Label;
    private javax.swing.JLabel functionLabel;
    private javax.swing.JLabel immediate16;
    private javax.swing.JLabel immediate32;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel jrLabel;
    private javax.swing.JLabel jumpLabel;
    private javax.swing.JLabel mem0;
    private javax.swing.JLabel mem100;
    private javax.swing.JLabel mem12;
    private javax.swing.JLabel mem16;
    private javax.swing.JLabel mem20;
    private javax.swing.JLabel mem24;
    private javax.swing.JLabel mem28;
    private javax.swing.JLabel mem32;
    private javax.swing.JLabel mem36;
    private javax.swing.JLabel mem4;
    private javax.swing.JLabel mem40;
    private javax.swing.JLabel mem44;
    private javax.swing.JLabel mem48;
    private javax.swing.JLabel mem52;
    private javax.swing.JLabel mem56;
    private javax.swing.JLabel mem60;
    private javax.swing.JLabel mem64;
    private javax.swing.JLabel mem68;
    private javax.swing.JLabel mem72;
    private javax.swing.JLabel mem76;
    private javax.swing.JLabel mem8;
    private javax.swing.JLabel mem80;
    private javax.swing.JLabel mem84;
    private javax.swing.JLabel mem88;
    private javax.swing.JLabel mem92;
    private javax.swing.JLabel mem96;
    private javax.swing.JLabel memReadLabel;
    private javax.swing.JLabel memToRegLabel;
    private javax.swing.JLabel memWriteLabel;
    private javax.swing.JLabel opCodeLabel;
    private javax.swing.JLabel pc;
    private javax.swing.JLabel pcLabel;
    private javax.swing.JLabel ra;
    private javax.swing.JLabel rd;
    private javax.swing.JLabel readDataLabel;
    private javax.swing.JLabel regDstLabel;
    private javax.swing.JLabel regWriteLabel;
    private javax.swing.JLabel rs;
    private javax.swing.JLabel rt;
    private javax.swing.JLabel s0;
    private javax.swing.JLabel s1;
    private javax.swing.JLabel s2;
    private javax.swing.JLabel s3;
    private javax.swing.JLabel s4;
    private javax.swing.JLabel s5;
    private javax.swing.JLabel s6;
    private javax.swing.JLabel s7;
    private javax.swing.JLabel shamtLabel;
    private javax.swing.JLabel shiftLeft2Label;
    private javax.swing.JLabel sp;
    private javax.swing.JLabel t0;
    private javax.swing.JLabel t1;
    private javax.swing.JLabel t2;
    private javax.swing.JLabel t3;
    private javax.swing.JLabel t4;
    private javax.swing.JLabel t5;
    private javax.swing.JLabel t6;
    private javax.swing.JLabel t7;
    private javax.swing.JLabel t8;
    private javax.swing.JLabel t9;
    private javax.swing.JLabel v0;
    private javax.swing.JLabel v1;
    private javax.swing.JLabel writeData;
    private javax.swing.JLabel writeReg;
    private javax.swing.JLabel zero;
    private javax.swing.JLabel zeroLabel;
    // End of variables declaration//GEN-END:variables
}
