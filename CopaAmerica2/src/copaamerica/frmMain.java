/*
Author: Jessee Clapier
Description: Create a simulation for the Copa America 
soccer tournament that creates arrays from the list boxes,
simulates games, keeps running totals for first round and 
then plays each consecutive round until a winner is determined.
 */
package copaamerica;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

/**
 *
 * @author Owner
 */
class Team {
    protected String TeamName;
    //only update during first round
    protected int Wins, Losses, Ties;

    //default constructor
    public Team() {
    }

    public Team(String TeamName) {
        this.TeamName = TeamName;
    }

    public Team(String TeamName, int Wins, int Losses) {
        this.TeamName = TeamName;
        this.Wins = Wins;
        this.Losses = Losses;
    }

    //getters and setters
    public String getTeamName() {
        return TeamName;
    }

    public void setTeamName(String TeamName) {
        this.TeamName = TeamName;
    }

    public int getWins() {
        return Wins;
    }

    public void setWins(int Wins) {
        this.Wins = Wins;
    }

    public int getLosses() {
        return Losses;
    }

    public void setLosses(int Losses) {
        this.Losses = Losses;
    }

    public int getTies() {
        return Ties;
    }

    public void setTies(int Ties) {
        this.Ties = Ties;
    }
    

}

class Soccer extends Team{
    //updated throughout tournament
    private String Group, Place;
    //only updated 1st round
    private int Points, GoalsScored, GoalsAllowed;
    
    //default constructor
    public Soccer() {
        super();
    }

    //call this when creating objects
    public Soccer(String Group, String TeamName) {
        super(TeamName);
        this.Group = Group;
    }

    //getters and setters
    public String getGroup() {
        return Group;
    }

    public void setGroup(String Group) {
        this.Group = Group;
    }

    public String getPlace() {
        return Place;
    }

    public void setPlace(String Place) {
        this.Place = Place;
    }

    public int getPoints() {
        return Points;
    }

    public void setPoints(int Points) {
        this.Points = Points;
    }

    public int getGoalsScored() {
        return GoalsScored;
    }

    public void setGoalsScored(int GoalsScored) {
        this.GoalsScored = GoalsScored;
    }

    public int getGoalsAllowed() {
        return GoalsAllowed;
    }

    public void setGoalsAllowed(int GoalsAllowed) {
        this.GoalsAllowed = GoalsAllowed;
    }
    
    //keep running totals for first round
    public void AddPoints(int iPoints){
        this.Points += iPoints;
    }
    
    public void AddGoalsScored(int iGoals){
        this.GoalsScored += iGoals;
    }
    
    public void AddGoalsAllowed(int iGoals){
        this.GoalsAllowed += iGoals;
    }
    
    //determine what place teams are
    public void SetPlace(int iPlace){
        if (iPlace == 0)
            this.Place = "1st";
        else if (iPlace == 1)
            this.Place = "2nd";
        else
            this.Place = "DNQ";
    }
    
    //add wins and losses and ties
    public void addWin(){
        this.Wins += 1;
    }
    public void addLoss(){
        this.Losses += 1;
    }
    public void addTie(){
        this.Ties += 1;
    }
}

//create comparator
class PointsComparator implements Comparator<Soccer>{
    
    @Override
    public int compare(Soccer s1, Soccer s2){
        int Points1 = s1.getPoints();
        int Points2 = s2.getPoints();
        
        return Integer.compare(Points2, Points1);
    }
}
public class frmMain extends javax.swing.JFrame {

    /**
     * Creates new form frmMain
     */
    public frmMain() {
        initComponents();
        
        //reset everything
        ResetAll();
    }
    
    //declare variables and random number generators
    int iCount, iLoopCount, iSeriesCount;
    boolean bHomeWin, bHomeLoss, bTie, bAwayWin, bAwayLoss;
    int iHomeScore, iAwayScore;
    Random RandomHome = new Random();
    Random RandomAway = new Random();
    
    //create 4 array lists
    ArrayList<Soccer> alGroupA = new ArrayList<>();
    ArrayList<Soccer> alGroupB = new ArrayList<>();
    ArrayList<Soccer> alGroupC = new ArrayList<>();
    ArrayList<Soccer> alGroupD = new ArrayList<>();
    
    //reset method
    public void ResetAll(){
        alGroupA.clear();
        alGroupB.clear();
        alGroupC.clear();
        alGroupD.clear();
        
        //clear labels
        lblGroupAFirst.setText("Group A 1st");
        lblGroupBFirst.setText("Group B 1st");
        lblGroupASecond.setText("Group A 2nd");
        lblGroupBSecond.setText("Group B 2nd");
        lblGroupCFirst.setText("Group C 1st");
        lblGroupCSecond.setText("Group C 2nd");
        lblGroupDFirst.setText("Group D 1st");
        lblGroupDSecond.setText("Group D 2nd");
        
        lblWinnerA1B2.setText("Winner A1 vs B2");
        lblWinnerB1A2.setText("Winner B1 vs A2");
        lblWinnerC1D2.setText("Winner C1 vs D2");
        lblWinnerD1C2.setText("Winner D1 vs C2");
        
        lblWinnerGroupAB.setText("Winner Group AB");
        lblWinnerGroupCD.setText("Winner Group CD");
        
        lblChampionTeamName.setText("Team Name");
        
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlCopa = new javax.swing.JPanel();
        pnlGroupA = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstGroupA = new javax.swing.JList<>();
        lblGroupA = new javax.swing.JLabel();
        pnlGroupB = new javax.swing.JPanel();
        lblGroupB = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        lstGroupB = new javax.swing.JList<>();
        pnlGroupC = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        lstGroupC = new javax.swing.JList<>();
        lblGroupC = new javax.swing.JLabel();
        pnlGroupD = new javax.swing.JPanel();
        lblGroupB1 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        lstGroupD = new javax.swing.JList<>();
        pnlRound2AB = new javax.swing.JPanel();
        lblGroupAFirst = new javax.swing.JLabel();
        lblGroupBSecond = new javax.swing.JLabel();
        pnlRound2BA = new javax.swing.JPanel();
        lblGroupBFirst = new javax.swing.JLabel();
        lblGroupASecond = new javax.swing.JLabel();
        pnlRound2CD = new javax.swing.JPanel();
        lblGroupCFirst = new javax.swing.JLabel();
        lblGroupDSecond = new javax.swing.JLabel();
        pnlRound2DC = new javax.swing.JPanel();
        lblGroupDFirst = new javax.swing.JLabel();
        lblGroupCSecond = new javax.swing.JLabel();
        pnlRound3AB = new javax.swing.JPanel();
        lblWinnerA1B2 = new javax.swing.JLabel();
        lblWinnerB1A2 = new javax.swing.JLabel();
        pnlRound3CD = new javax.swing.JPanel();
        lblWinnerC1D2 = new javax.swing.JLabel();
        lblWinnerD1C2 = new javax.swing.JLabel();
        pnlFinal = new javax.swing.JPanel();
        lblWinnerGroupAB = new javax.swing.JLabel();
        lblWinnerGroupCD = new javax.swing.JLabel();
        lblRound1 = new javax.swing.JLabel();
        lblRound2 = new javax.swing.JLabel();
        lblRound3 = new javax.swing.JLabel();
        lblFinal = new javax.swing.JLabel();
        lblChampion = new javax.swing.JLabel();
        lblChampionTeamName = new javax.swing.JLabel();
        pnlLineARound2 = new javax.swing.JPanel();
        pnlLineBRound2 = new javax.swing.JPanel();
        pnlLineCRound2 = new javax.swing.JPanel();
        pnlLineDRound2 = new javax.swing.JPanel();
        pnlLineBRound2toRound3 = new javax.swing.JPanel();
        pnlLineARound2toRound3 = new javax.swing.JPanel();
        pnlLineJoinAB = new javax.swing.JPanel();
        pnlLineCRound2toRound3 = new javax.swing.JPanel();
        pnlLineDRound2toRound3 = new javax.swing.JPanel();
        pnlLineJoinCD = new javax.swing.JPanel();
        pnlLineABto3 = new javax.swing.JPanel();
        pnlCDto3 = new javax.swing.JPanel();
        pnlLineABRound3toFinal = new javax.swing.JPanel();
        pnlLineCDRound3toFinal = new javax.swing.JPanel();
        pnlLineJoinABCD = new javax.swing.JPanel();
        pnlLineABCDtoFinal = new javax.swing.JPanel();
        pnlButtons = new javax.swing.JPanel();
        btnPlay = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        btnCose = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("COPA AMERICA");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlCopa.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlGroupA.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lstGroupA.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Colombia", "Costa Rica", "Paraguay", "USA" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(lstGroupA);

        lblGroupA.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblGroupA.setText("GROUP A");

        javax.swing.GroupLayout pnlGroupALayout = new javax.swing.GroupLayout(pnlGroupA);
        pnlGroupA.setLayout(pnlGroupALayout);
        pnlGroupALayout.setHorizontalGroup(
            pnlGroupALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlGroupALayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(pnlGroupALayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(lblGroupA)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlGroupALayout.setVerticalGroup(
            pnlGroupALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlGroupALayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblGroupA)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pnlCopa.add(pnlGroupA, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 120, 150));

        pnlGroupB.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblGroupB.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblGroupB.setText("GROUP B");

        lstGroupB.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Brazil", "Ecuador", "Haiti", "Peru" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(lstGroupB);

        javax.swing.GroupLayout pnlGroupBLayout = new javax.swing.GroupLayout(pnlGroupB);
        pnlGroupB.setLayout(pnlGroupBLayout);
        pnlGroupBLayout.setHorizontalGroup(
            pnlGroupBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlGroupBLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(lblGroupB)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlGroupBLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnlGroupBLayout.setVerticalGroup(
            pnlGroupBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlGroupBLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblGroupB)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pnlCopa.add(pnlGroupB, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 224, -1, -1));

        pnlGroupC.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lstGroupC.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Jamaica", "Mexico", "Uruguay", "Venezuela" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane3.setViewportView(lstGroupC);

        lblGroupC.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblGroupC.setText("GROUP C");

        javax.swing.GroupLayout pnlGroupCLayout = new javax.swing.GroupLayout(pnlGroupC);
        pnlGroupC.setLayout(pnlGroupCLayout);
        pnlGroupCLayout.setHorizontalGroup(
            pnlGroupCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlGroupCLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(pnlGroupCLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(lblGroupC)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlGroupCLayout.setVerticalGroup(
            pnlGroupCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlGroupCLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblGroupC)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pnlCopa.add(pnlGroupC, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 410, 120, 150));

        pnlGroupD.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblGroupB1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblGroupB1.setText("GROUP D");

        lstGroupD.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Argentina", "Bolivia", "Chile", "Panama" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane4.setViewportView(lstGroupD);

        javax.swing.GroupLayout pnlGroupDLayout = new javax.swing.GroupLayout(pnlGroupD);
        pnlGroupD.setLayout(pnlGroupDLayout);
        pnlGroupDLayout.setHorizontalGroup(
            pnlGroupDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlGroupDLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(lblGroupB1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlGroupDLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnlGroupDLayout.setVerticalGroup(
            pnlGroupDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlGroupDLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblGroupB1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pnlCopa.add(pnlGroupD, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 586, -1, -1));

        pnlRound2AB.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblGroupAFirst.setText("Group A 1st");

        lblGroupBSecond.setText("Group B 2nd");

        javax.swing.GroupLayout pnlRound2ABLayout = new javax.swing.GroupLayout(pnlRound2AB);
        pnlRound2AB.setLayout(pnlRound2ABLayout);
        pnlRound2ABLayout.setHorizontalGroup(
            pnlRound2ABLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRound2ABLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlRound2ABLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblGroupAFirst)
                    .addComponent(lblGroupBSecond))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlRound2ABLayout.setVerticalGroup(
            pnlRound2ABLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRound2ABLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(lblGroupAFirst)
                .addGap(18, 18, 18)
                .addComponent(lblGroupBSecond)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        pnlCopa.add(pnlRound2AB, new org.netbeans.lib.awtextra.AbsoluteConstraints(167, 85, 123, -1));

        pnlRound2BA.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblGroupBFirst.setText("Group B 1st");

        lblGroupASecond.setText("Group A 2nd");

        javax.swing.GroupLayout pnlRound2BALayout = new javax.swing.GroupLayout(pnlRound2BA);
        pnlRound2BA.setLayout(pnlRound2BALayout);
        pnlRound2BALayout.setHorizontalGroup(
            pnlRound2BALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRound2BALayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlRound2BALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblGroupBFirst)
                    .addComponent(lblGroupASecond))
                .addContainerGap(51, Short.MAX_VALUE))
        );
        pnlRound2BALayout.setVerticalGroup(
            pnlRound2BALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRound2BALayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(lblGroupBFirst)
                .addGap(18, 18, 18)
                .addComponent(lblGroupASecond)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        pnlCopa.add(pnlRound2BA, new org.netbeans.lib.awtextra.AbsoluteConstraints(167, 253, -1, -1));

        pnlRound2CD.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblGroupCFirst.setText("Group C 1st");

        lblGroupDSecond.setText("Group D 2nd");

        javax.swing.GroupLayout pnlRound2CDLayout = new javax.swing.GroupLayout(pnlRound2CD);
        pnlRound2CD.setLayout(pnlRound2CDLayout);
        pnlRound2CDLayout.setHorizontalGroup(
            pnlRound2CDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRound2CDLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlRound2CDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblGroupCFirst)
                    .addComponent(lblGroupDSecond))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlRound2CDLayout.setVerticalGroup(
            pnlRound2CDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRound2CDLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(lblGroupCFirst)
                .addGap(18, 18, 18)
                .addComponent(lblGroupDSecond)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        pnlCopa.add(pnlRound2CD, new org.netbeans.lib.awtextra.AbsoluteConstraints(167, 431, 123, -1));

        pnlRound2DC.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblGroupDFirst.setText("Group D 1st");

        lblGroupCSecond.setText("Group C 2nd");

        javax.swing.GroupLayout pnlRound2DCLayout = new javax.swing.GroupLayout(pnlRound2DC);
        pnlRound2DC.setLayout(pnlRound2DCLayout);
        pnlRound2DCLayout.setHorizontalGroup(
            pnlRound2DCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRound2DCLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlRound2DCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblGroupDFirst)
                    .addComponent(lblGroupCSecond))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlRound2DCLayout.setVerticalGroup(
            pnlRound2DCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRound2DCLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(lblGroupDFirst)
                .addGap(18, 18, 18)
                .addComponent(lblGroupCSecond)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        pnlCopa.add(pnlRound2DC, new org.netbeans.lib.awtextra.AbsoluteConstraints(167, 611, 123, -1));

        pnlRound3AB.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblWinnerA1B2.setText("Winner A1 vs B2");

        lblWinnerB1A2.setText("Winner B1 vs A2");

        javax.swing.GroupLayout pnlRound3ABLayout = new javax.swing.GroupLayout(pnlRound3AB);
        pnlRound3AB.setLayout(pnlRound3ABLayout);
        pnlRound3ABLayout.setHorizontalGroup(
            pnlRound3ABLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRound3ABLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlRound3ABLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblWinnerA1B2)
                    .addComponent(lblWinnerB1A2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlRound3ABLayout.setVerticalGroup(
            pnlRound3ABLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRound3ABLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(lblWinnerA1B2)
                .addGap(18, 18, 18)
                .addComponent(lblWinnerB1A2)
                .addContainerGap(33, Short.MAX_VALUE))
        );

        pnlCopa.add(pnlRound3AB, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 170, 180, -1));

        pnlRound3CD.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblWinnerC1D2.setText("Winner C1 vs D2");

        lblWinnerD1C2.setText("Winner D1 vs C2");

        javax.swing.GroupLayout pnlRound3CDLayout = new javax.swing.GroupLayout(pnlRound3CD);
        pnlRound3CD.setLayout(pnlRound3CDLayout);
        pnlRound3CDLayout.setHorizontalGroup(
            pnlRound3CDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRound3CDLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlRound3CDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblWinnerC1D2)
                    .addComponent(lblWinnerD1C2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlRound3CDLayout.setVerticalGroup(
            pnlRound3CDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRound3CDLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(lblWinnerC1D2)
                .addGap(18, 18, 18)
                .addComponent(lblWinnerD1C2)
                .addContainerGap(33, Short.MAX_VALUE))
        );

        pnlCopa.add(pnlRound3CD, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 520, 180, -1));

        pnlFinal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblWinnerGroupAB.setText("Winner Group AB");

        lblWinnerGroupCD.setText("Winner Group CD");

        javax.swing.GroupLayout pnlFinalLayout = new javax.swing.GroupLayout(pnlFinal);
        pnlFinal.setLayout(pnlFinalLayout);
        pnlFinalLayout.setHorizontalGroup(
            pnlFinalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFinalLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(pnlFinalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblWinnerGroupCD)
                    .addComponent(lblWinnerGroupAB))
                .addContainerGap(56, Short.MAX_VALUE))
        );
        pnlFinalLayout.setVerticalGroup(
            pnlFinalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFinalLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(lblWinnerGroupAB)
                .addGap(18, 18, 18)
                .addComponent(lblWinnerGroupCD)
                .addContainerGap(47, Short.MAX_VALUE))
        );

        pnlCopa.add(pnlFinal, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 330, -1, -1));

        lblRound1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblRound1.setText("ROUND 1");
        pnlCopa.add(lblRound1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, 80, 30));

        lblRound2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblRound2.setText("ROUND 2 - Only play 1 game");
        pnlCopa.add(lblRound2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 60, -1, -1));

        lblRound3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblRound3.setText("ROUND 3 - Only play 1 game");
        pnlCopa.add(lblRound3, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 140, -1, -1));

        lblFinal.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblFinal.setText("FINAL - Play 3 times");
        pnlCopa.add(lblFinal, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 300, -1, -1));

        lblChampion.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblChampion.setForeground(new java.awt.Color(255, 51, 51));
        lblChampion.setText("CHAMPION");
        pnlCopa.add(lblChampion, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 360, -1, -1));

        lblChampionTeamName.setForeground(new java.awt.Color(0, 0, 153));
        lblChampionTeamName.setText("Team Name");
        pnlCopa.add(lblChampionTeamName, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 390, -1, -1));

        pnlLineARound2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout pnlLineARound2Layout = new javax.swing.GroupLayout(pnlLineARound2);
        pnlLineARound2.setLayout(pnlLineARound2Layout);
        pnlLineARound2Layout.setHorizontalGroup(
            pnlLineARound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 38, Short.MAX_VALUE)
        );
        pnlLineARound2Layout.setVerticalGroup(
            pnlLineARound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        pnlCopa.add(pnlLineARound2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 130, 40, -1));

        pnlLineBRound2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout pnlLineBRound2Layout = new javax.swing.GroupLayout(pnlLineBRound2);
        pnlLineBRound2.setLayout(pnlLineBRound2Layout);
        pnlLineBRound2Layout.setHorizontalGroup(
            pnlLineBRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 38, Short.MAX_VALUE)
        );
        pnlLineBRound2Layout.setVerticalGroup(
            pnlLineBRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        pnlCopa.add(pnlLineBRound2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 298, 40, -1));

        pnlLineCRound2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout pnlLineCRound2Layout = new javax.swing.GroupLayout(pnlLineCRound2);
        pnlLineCRound2.setLayout(pnlLineCRound2Layout);
        pnlLineCRound2Layout.setHorizontalGroup(
            pnlLineCRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 38, Short.MAX_VALUE)
        );
        pnlLineCRound2Layout.setVerticalGroup(
            pnlLineCRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        pnlCopa.add(pnlLineCRound2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 478, 40, -1));

        pnlLineDRound2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout pnlLineDRound2Layout = new javax.swing.GroupLayout(pnlLineDRound2);
        pnlLineDRound2.setLayout(pnlLineDRound2Layout);
        pnlLineDRound2Layout.setHorizontalGroup(
            pnlLineDRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 38, Short.MAX_VALUE)
        );
        pnlLineDRound2Layout.setVerticalGroup(
            pnlLineDRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        pnlCopa.add(pnlLineDRound2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 660, 40, -1));

        pnlLineBRound2toRound3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout pnlLineBRound2toRound3Layout = new javax.swing.GroupLayout(pnlLineBRound2toRound3);
        pnlLineBRound2toRound3.setLayout(pnlLineBRound2toRound3Layout);
        pnlLineBRound2toRound3Layout.setHorizontalGroup(
            pnlLineBRound2toRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 18, Short.MAX_VALUE)
        );
        pnlLineBRound2toRound3Layout.setVerticalGroup(
            pnlLineBRound2toRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        pnlCopa.add(pnlLineBRound2toRound3, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 298, 20, -1));

        pnlLineARound2toRound3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout pnlLineARound2toRound3Layout = new javax.swing.GroupLayout(pnlLineARound2toRound3);
        pnlLineARound2toRound3.setLayout(pnlLineARound2toRound3Layout);
        pnlLineARound2toRound3Layout.setHorizontalGroup(
            pnlLineARound2toRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 18, Short.MAX_VALUE)
        );
        pnlLineARound2toRound3Layout.setVerticalGroup(
            pnlLineARound2toRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        pnlCopa.add(pnlLineARound2toRound3, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 130, 20, -1));

        pnlLineJoinAB.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout pnlLineJoinABLayout = new javax.swing.GroupLayout(pnlLineJoinAB);
        pnlLineJoinAB.setLayout(pnlLineJoinABLayout);
        pnlLineJoinABLayout.setHorizontalGroup(
            pnlLineJoinABLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pnlLineJoinABLayout.setVerticalGroup(
            pnlLineJoinABLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 168, Short.MAX_VALUE)
        );

        pnlCopa.add(pnlLineJoinAB, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 130, -1, 170));

        pnlLineCRound2toRound3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout pnlLineCRound2toRound3Layout = new javax.swing.GroupLayout(pnlLineCRound2toRound3);
        pnlLineCRound2toRound3.setLayout(pnlLineCRound2toRound3Layout);
        pnlLineCRound2toRound3Layout.setHorizontalGroup(
            pnlLineCRound2toRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 18, Short.MAX_VALUE)
        );
        pnlLineCRound2toRound3Layout.setVerticalGroup(
            pnlLineCRound2toRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        pnlCopa.add(pnlLineCRound2toRound3, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 480, 20, -1));

        pnlLineDRound2toRound3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout pnlLineDRound2toRound3Layout = new javax.swing.GroupLayout(pnlLineDRound2toRound3);
        pnlLineDRound2toRound3.setLayout(pnlLineDRound2toRound3Layout);
        pnlLineDRound2toRound3Layout.setHorizontalGroup(
            pnlLineDRound2toRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 18, Short.MAX_VALUE)
        );
        pnlLineDRound2toRound3Layout.setVerticalGroup(
            pnlLineDRound2toRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        pnlCopa.add(pnlLineDRound2toRound3, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 660, 20, -1));

        pnlLineJoinCD.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout pnlLineJoinCDLayout = new javax.swing.GroupLayout(pnlLineJoinCD);
        pnlLineJoinCD.setLayout(pnlLineJoinCDLayout);
        pnlLineJoinCDLayout.setHorizontalGroup(
            pnlLineJoinCDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pnlLineJoinCDLayout.setVerticalGroup(
            pnlLineJoinCDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 178, Short.MAX_VALUE)
        );

        pnlCopa.add(pnlLineJoinCD, new org.netbeans.lib.awtextra.AbsoluteConstraints(308, 480, -1, 180));

        pnlLineABto3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout pnlLineABto3Layout = new javax.swing.GroupLayout(pnlLineABto3);
        pnlLineABto3.setLayout(pnlLineABto3Layout);
        pnlLineABto3Layout.setHorizontalGroup(
            pnlLineABto3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 28, Short.MAX_VALUE)
        );
        pnlLineABto3Layout.setVerticalGroup(
            pnlLineABto3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        pnlCopa.add(pnlLineABto3, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 218, 30, -1));

        pnlCDto3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout pnlCDto3Layout = new javax.swing.GroupLayout(pnlCDto3);
        pnlCDto3.setLayout(pnlCDto3Layout);
        pnlCDto3Layout.setHorizontalGroup(
            pnlCDto3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 28, Short.MAX_VALUE)
        );
        pnlCDto3Layout.setVerticalGroup(
            pnlCDto3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        pnlCopa.add(pnlCDto3, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 568, 30, -1));

        pnlLineABRound3toFinal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout pnlLineABRound3toFinalLayout = new javax.swing.GroupLayout(pnlLineABRound3toFinal);
        pnlLineABRound3toFinal.setLayout(pnlLineABRound3toFinalLayout);
        pnlLineABRound3toFinalLayout.setHorizontalGroup(
            pnlLineABRound3toFinalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 18, Short.MAX_VALUE)
        );
        pnlLineABRound3toFinalLayout.setVerticalGroup(
            pnlLineABRound3toFinalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        pnlCopa.add(pnlLineABRound3toFinal, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 220, 20, -1));

        pnlLineCDRound3toFinal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout pnlLineCDRound3toFinalLayout = new javax.swing.GroupLayout(pnlLineCDRound3toFinal);
        pnlLineCDRound3toFinal.setLayout(pnlLineCDRound3toFinalLayout);
        pnlLineCDRound3toFinalLayout.setHorizontalGroup(
            pnlLineCDRound3toFinalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 18, Short.MAX_VALUE)
        );
        pnlLineCDRound3toFinalLayout.setVerticalGroup(
            pnlLineCDRound3toFinalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        pnlCopa.add(pnlLineCDRound3toFinal, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 570, 20, -1));

        pnlLineJoinABCD.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout pnlLineJoinABCDLayout = new javax.swing.GroupLayout(pnlLineJoinABCD);
        pnlLineJoinABCD.setLayout(pnlLineJoinABCDLayout);
        pnlLineJoinABCDLayout.setHorizontalGroup(
            pnlLineJoinABCDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pnlLineJoinABCDLayout.setVerticalGroup(
            pnlLineJoinABCDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 348, Short.MAX_VALUE)
        );

        pnlCopa.add(pnlLineJoinABCD, new org.netbeans.lib.awtextra.AbsoluteConstraints(538, 220, -1, 350));

        pnlLineABCDtoFinal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout pnlLineABCDtoFinalLayout = new javax.swing.GroupLayout(pnlLineABCDtoFinal);
        pnlLineABCDtoFinal.setLayout(pnlLineABCDtoFinalLayout);
        pnlLineABCDtoFinalLayout.setHorizontalGroup(
            pnlLineABCDtoFinalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 28, Short.MAX_VALUE)
        );
        pnlLineABCDtoFinalLayout.setVerticalGroup(
            pnlLineABCDtoFinalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        pnlCopa.add(pnlLineABCDtoFinal, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 390, 30, -1));

        pnlButtons.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnPlay.setForeground(new java.awt.Color(0, 0, 153));
        btnPlay.setText("Play");
        btnPlay.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPlayMouseClicked(evt);
            }
        });

        btnReset.setForeground(new java.awt.Color(0, 0, 153));
        btnReset.setText("Reset");
        btnReset.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnResetMouseClicked(evt);
            }
        });

        btnCose.setForeground(new java.awt.Color(0, 0, 153));
        btnCose.setText("Close");
        btnCose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCoseMouseClicked(evt);
            }
        });
        btnCose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCoseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlButtonsLayout = new javax.swing.GroupLayout(pnlButtons);
        pnlButtons.setLayout(pnlButtonsLayout);
        pnlButtonsLayout.setHorizontalGroup(
            pnlButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlButtonsLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(pnlButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnCose)
                    .addComponent(btnReset, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnPlay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlButtonsLayout.setVerticalGroup(
            pnlButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlButtonsLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(btnPlay)
                .addGap(26, 26, 26)
                .addComponent(btnReset)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCose)
                .addGap(25, 25, 25))
        );

        pnlCopa.add(pnlButtons, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 550, 110, 180));

        getContentPane().add(pnlCopa, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 920, 760));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCoseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCoseMouseClicked
        // TODO add your handling code here:
        System.exit(0);
        
    }//GEN-LAST:event_btnCoseMouseClicked

    private void btnCoseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCoseActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCoseActionPerformed

    private void btnPlayMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPlayMouseClicked
        // TODO add your handling code here:
        
        ResetAll();
        
        //add objects to arrays from lst boxes
        for (iCount = 0; iCount < lstGroupA.getModel().getSize(); iCount++){
            alGroupA.add(new Soccer("A", lstGroupA.getModel().getElementAt(iCount)));
        }
        for (iCount = 0; iCount < lstGroupB.getModel().getSize(); iCount++){
            alGroupB.add(new Soccer("B", lstGroupB.getModel().getElementAt(iCount)));
        }
        for (iCount = 0; iCount < lstGroupC.getModel().getSize(); iCount++){
            alGroupC.add(new Soccer("C", lstGroupC.getModel().getElementAt(iCount)));
        }
        for (iCount = 0; iCount < lstGroupD.getModel().getSize(); iCount++){
            alGroupD.add(new Soccer("D", lstGroupD.getModel().getElementAt(iCount)));
        }
        
        //ROUND 1
        //play each group, iCount will be home and iLoop will be away
        //group A
        for (iCount = 0; iCount < alGroupA.size(); iCount++){
            for (iLoopCount = (iCount + 1); iLoopCount < lstGroupA.getModel().getSize(); iLoopCount++ ){
                //generate random number 
                iHomeScore = RandomHome.nextInt(9);
                iAwayScore = RandomAway.nextInt(9);
                
                //determine winner, loser or tie
                if (iHomeScore > iAwayScore){
                    alGroupA.get(iCount).addWin();
                    alGroupA.get(iLoopCount).addLoss();
                    bHomeWin = true;
                    bAwayWin = false;
                }
                else if (iHomeScore < iAwayScore){
                    alGroupA.get(iCount).addLoss();
                    alGroupA.get(iLoopCount).addWin();
                    bHomeWin = false;
                    bAwayWin = true;
                }
                else if (iHomeScore == iAwayScore){
                    alGroupA.get(iCount).addTie();
                    alGroupA.get(iLoopCount).addTie();
                    bTie = true;
                }
                
                //add points
                if (bHomeWin)
                    alGroupA.get(iCount).AddPoints(3);
                else if (bAwayWin)
                    alGroupA.get(iLoopCount).AddPoints(3);
                else if (bTie)
                    alGroupA.get(iCount).AddPoints(1);
                    alGroupA.get(iLoopCount).AddPoints(1);
                    
                //keep running total of goals scored for and against
                alGroupA.get(iCount).AddGoalsScored(iHomeScore);
                alGroupA.get(iCount).AddGoalsAllowed(iAwayScore);
                alGroupA.get(iLoopCount).AddGoalsScored(iAwayScore);
                alGroupA.get(iLoopCount).AddGoalsAllowed(iHomeScore);              
            }
        }
        
        //sort group A array
        Collections.sort(alGroupA, new PointsComparator());
        
        //assign places
        for (int iPlace = 1, iCount = 0; iCount < alGroupA.size(); iCount++){
            alGroupA.get(iCount).SetPlace(iPlace);
            iPlace++;
        }
        
        
        //print out winners to labels
        lblGroupAFirst.setText(String.valueOf(alGroupA.get(0).getTeamName()));
        lblGroupASecond.setText(String.valueOf(alGroupA.get(1).getTeamName()));

        //play group B
        for (iCount = 0; iCount < alGroupB.size(); iCount++){
            for (iLoopCount = (iCount + 1); iLoopCount < alGroupB.size(); iLoopCount++ ){
                //generate random number 
                iHomeScore = RandomHome.nextInt(9);
                iAwayScore = RandomAway.nextInt(9);
                
                //determine winner, loser or tie
                if (iHomeScore > iAwayScore){
                    alGroupB.get(iCount).addWin();
                    alGroupB.get(iLoopCount).addLoss();
                    bHomeWin = true;
                    bAwayWin = false;
                }
                else if (iHomeScore < iAwayScore){
                    alGroupB.get(iCount).addLoss();
                    alGroupB.get(iLoopCount).addWin();
                    bHomeWin = false;
                    bAwayWin = true;
                }
                else if (iHomeScore == iAwayScore){
                    alGroupB.get(iCount).addTie();
                    alGroupB.get(iLoopCount).addTie();
                    bTie = true;
                }
                
                //add points
                if (bHomeWin)
                    alGroupB.get(iCount).AddPoints(3);
                else if (bAwayWin)
                    alGroupB.get(iLoopCount).AddPoints(3);
                else if (bTie)
                    alGroupB.get(iCount).AddPoints(1);
                    alGroupB.get(iLoopCount).AddPoints(1);
                    
                //keep running total of goals scored for and against
                alGroupB.get(iCount).AddGoalsScored(iHomeScore);
                alGroupB.get(iCount).AddGoalsAllowed(iAwayScore);
                alGroupB.get(iLoopCount).AddGoalsScored(iAwayScore);
                alGroupB.get(iLoopCount).AddGoalsAllowed(iHomeScore);              
            }
        }
        
        //sort group B array
        Collections.sort(alGroupB, new PointsComparator());
        
        //assign places
        for (int iPlace = 1, iCount = 0; iCount < alGroupB.size(); iCount++){
            alGroupB.get(iCount).SetPlace(iPlace);
            iPlace++;
        }
        
        //print out winners to labels
        lblGroupBFirst.setText(String.valueOf(alGroupB.get(0).getTeamName()));
        lblGroupBSecond.setText(String.valueOf(alGroupB.get(1).getTeamName()));
        
        //play group C
        for (iCount = 0; iCount < alGroupC.size(); iCount++){
            for (iLoopCount = (iCount + 1); iLoopCount < alGroupC.size(); iLoopCount++ ){
                //generate random number 
                iHomeScore = RandomHome.nextInt(9);
                iAwayScore = RandomAway.nextInt(9);
                
                //determine winner, loser or tie
                if (iHomeScore > iAwayScore){
                    alGroupC.get(iCount).addWin();
                    alGroupC.get(iLoopCount).addLoss();
                    bHomeWin = true;
                    bAwayWin = false;
                }
                else if (iHomeScore < iAwayScore){
                    alGroupC.get(iCount).addLoss();
                    alGroupC.get(iLoopCount).addWin();
                    bHomeWin = false;
                    bAwayWin = true;
                }
                else if (iHomeScore == iAwayScore){
                    alGroupC.get(iCount).addTie();
                    alGroupC.get(iLoopCount).addTie();
                    bTie = true;
                }
                
                //add points
                if (bHomeWin)
                    alGroupC.get(iCount).AddPoints(3);
                else if (bAwayWin)
                    alGroupC.get(iLoopCount).AddPoints(3);
                else if (bTie)
                    alGroupC.get(iCount).AddPoints(1);
                    alGroupC.get(iLoopCount).AddPoints(1);
                    
                //keep running total of goals scored for and against
                alGroupC.get(iCount).AddGoalsScored(iHomeScore);
                alGroupC.get(iCount).AddGoalsAllowed(iAwayScore);
                alGroupC.get(iLoopCount).AddGoalsScored(iAwayScore);
                alGroupC.get(iLoopCount).AddGoalsAllowed(iHomeScore);              
            }
        }
        
        //sort group C array
        Collections.sort(alGroupC, new PointsComparator());
        
        //assign places
        for (int iPlace = 1, iCount = 0; iCount < alGroupC.size(); iCount++){
            alGroupC.get(iCount).SetPlace(iPlace);
            iPlace++;
        }
        
        //print out winners to labels
        lblGroupCFirst.setText(String.valueOf(alGroupC.get(0).getTeamName()));
        lblGroupCSecond.setText(String.valueOf(alGroupC.get(1).getTeamName()));
        
        //play group D
        for (iCount = 0; iCount < alGroupD.size(); iCount++){
            for (iLoopCount = (iCount + 1); iLoopCount < alGroupD.size(); iLoopCount++ ){
                //generate random number 
                iHomeScore = RandomHome.nextInt(9);
                iAwayScore = RandomAway.nextInt(9);
                
                //determine winner, loser or tie
                if (iHomeScore > iAwayScore){
                    alGroupD.get(iCount).addWin();
                    alGroupD.get(iLoopCount).addLoss();
                    bHomeWin = true;
                    bAwayWin = false;
                }
                else if (iHomeScore < iAwayScore){
                    alGroupD.get(iCount).addLoss();
                    alGroupD.get(iLoopCount).addWin();
                    bHomeWin = false;
                    bAwayWin = true;
                }
                else if (iHomeScore == iAwayScore){
                    alGroupD.get(iCount).addTie();
                    alGroupD.get(iLoopCount).addTie();
                    bTie = true;
                }
                
                //add points
                if (bHomeWin)
                    alGroupD.get(iCount).AddPoints(3);
                else if (bAwayWin)
                    alGroupD.get(iLoopCount).AddPoints(3);
                else if (bTie)
                    alGroupD.get(iCount).AddPoints(1);
                    alGroupD.get(iLoopCount).AddPoints(1);
                    
                //keep running total of goals scored for and against
                alGroupD.get(iCount).AddGoalsScored(iHomeScore);
                alGroupD.get(iCount).AddGoalsAllowed(iAwayScore);
                alGroupD.get(iLoopCount).AddGoalsScored(iAwayScore);
                alGroupD.get(iLoopCount).AddGoalsAllowed(iHomeScore);              
            }
        }
        
        //sort group D array
        Collections.sort(alGroupD, new PointsComparator());
        
        //assign places
        for (int iPlace = 1, iCount = 0; iCount < alGroupD.size(); iCount++){
            alGroupD.get(iCount).SetPlace(iPlace);
            iPlace++;
        }
        
        //print out winners to labels
        lblGroupDFirst.setText(String.valueOf(alGroupD.get(0).getTeamName()));
        lblGroupDSecond.setText(String.valueOf(alGroupD.get(1).getTeamName()));
        
        
        //ROUND 2
        //not ties allowed
        //A1 vs B2
        do {iHomeScore = RandomHome.nextInt(9);
        iAwayScore = RandomAway.nextInt(9);
        } while (iHomeScore == iAwayScore);
        
        if (iHomeScore > iAwayScore)
            lblWinnerA1B2.setText(lblGroupAFirst.getText());
        else if (iHomeScore < iAwayScore)
            lblWinnerA1B2.setText(lblGroupBSecond.getText());
        
        //B1 vs A2
        do {iHomeScore = RandomHome.nextInt(9);
        iAwayScore = RandomAway.nextInt(9);
        } while (iHomeScore == iAwayScore);
        
        if (iHomeScore > iAwayScore)
            lblWinnerB1A2.setText(lblGroupBFirst.getText());
        else if (iHomeScore < iAwayScore)
            lblWinnerB1A2.setText(lblGroupASecond.getText());
        
        //C1 vs D2
        do {iHomeScore = RandomHome.nextInt(9);
        iAwayScore = RandomAway.nextInt(9);
        } while (iHomeScore == iAwayScore);
        
        if (iHomeScore > iAwayScore)
            lblWinnerC1D2.setText(lblGroupCFirst.getText());
        else if (iHomeScore < iAwayScore)
            lblWinnerC1D2.setText(lblGroupDSecond.getText());
        
        //D1 vs C2
        do {iHomeScore = RandomHome.nextInt(9);
        iAwayScore = RandomAway.nextInt(9);
        } while (iHomeScore == iAwayScore);
        
        if (iHomeScore > iAwayScore)
            lblWinnerD1C2.setText(lblGroupDFirst.getText());
        else if (iHomeScore < iAwayScore)
            lblWinnerD1C2.setText(lblGroupCSecond.getText());
        
        //Round 3
        //group AB
        do {iHomeScore = RandomHome.nextInt(9);
        iAwayScore = RandomAway.nextInt(9);
        } while (iHomeScore == iAwayScore);
        
        if (iHomeScore > iAwayScore)
            lblWinnerGroupAB.setText(lblWinnerA1B2.getText());
        else if (iHomeScore < iAwayScore)
            lblWinnerGroupAB.setText(lblWinnerB1A2.getText());
        
        //group CD
        do {iHomeScore = RandomHome.nextInt(9);
        iAwayScore = RandomAway.nextInt(9);
        } while (iHomeScore == iAwayScore);
        
        if (iHomeScore > iAwayScore)
            lblWinnerGroupCD.setText(lblWinnerC1D2.getText());
        else if (iHomeScore < iAwayScore)
            lblWinnerGroupCD.setText(lblWinnerD1C2.getText());
        
        
        //FINAL ROUND
        int iFinalWinsHome = 0, iFinalWinsAway = 0;
        for (iSeriesCount = 0; iSeriesCount < 3; iSeriesCount++){
            if ((iFinalWinsHome != 2) && (iFinalWinsAway !=2)){
                do {iHomeScore = RandomHome.nextInt(9);
                    iAwayScore = RandomAway.nextInt(9);
                } while (iHomeScore == iAwayScore);

                if (iHomeScore > iAwayScore){
                    iFinalWinsHome++;
                }
                else if (iHomeScore < iAwayScore){
                    iFinalWinsAway++;
                }
            }
        }
        
        //print out champion
        if (iFinalWinsHome == 2)
            lblChampionTeamName.setText(lblWinnerGroupAB.getText());
        else if (iFinalWinsAway == 2)
            lblChampionTeamName.setText(lblWinnerGroupCD.getText());
    }//GEN-LAST:event_btnPlayMouseClicked

    private void btnResetMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnResetMouseClicked
        // TODO add your handling code here:
        //resets everything
        ResetAll();
    }//GEN-LAST:event_btnResetMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
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
            java.util.logging.Logger.getLogger(frmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmMain().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCose;
    private javax.swing.JButton btnPlay;
    private javax.swing.JButton btnReset;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel lblChampion;
    private javax.swing.JLabel lblChampionTeamName;
    private javax.swing.JLabel lblFinal;
    private javax.swing.JLabel lblGroupA;
    private javax.swing.JLabel lblGroupAFirst;
    private javax.swing.JLabel lblGroupASecond;
    private javax.swing.JLabel lblGroupB;
    private javax.swing.JLabel lblGroupB1;
    private javax.swing.JLabel lblGroupBFirst;
    private javax.swing.JLabel lblGroupBSecond;
    private javax.swing.JLabel lblGroupC;
    private javax.swing.JLabel lblGroupCFirst;
    private javax.swing.JLabel lblGroupCSecond;
    private javax.swing.JLabel lblGroupDFirst;
    private javax.swing.JLabel lblGroupDSecond;
    private javax.swing.JLabel lblRound1;
    private javax.swing.JLabel lblRound2;
    private javax.swing.JLabel lblRound3;
    private javax.swing.JLabel lblWinnerA1B2;
    private javax.swing.JLabel lblWinnerB1A2;
    private javax.swing.JLabel lblWinnerC1D2;
    private javax.swing.JLabel lblWinnerD1C2;
    private javax.swing.JLabel lblWinnerGroupAB;
    private javax.swing.JLabel lblWinnerGroupCD;
    private javax.swing.JList<String> lstGroupA;
    private javax.swing.JList<String> lstGroupB;
    private javax.swing.JList<String> lstGroupC;
    private javax.swing.JList<String> lstGroupD;
    private javax.swing.JPanel pnlButtons;
    private javax.swing.JPanel pnlCDto3;
    private javax.swing.JPanel pnlCopa;
    private javax.swing.JPanel pnlFinal;
    private javax.swing.JPanel pnlGroupA;
    private javax.swing.JPanel pnlGroupB;
    private javax.swing.JPanel pnlGroupC;
    private javax.swing.JPanel pnlGroupD;
    private javax.swing.JPanel pnlLineABCDtoFinal;
    private javax.swing.JPanel pnlLineABRound3toFinal;
    private javax.swing.JPanel pnlLineABto3;
    private javax.swing.JPanel pnlLineARound2;
    private javax.swing.JPanel pnlLineARound2toRound3;
    private javax.swing.JPanel pnlLineBRound2;
    private javax.swing.JPanel pnlLineBRound2toRound3;
    private javax.swing.JPanel pnlLineCDRound3toFinal;
    private javax.swing.JPanel pnlLineCRound2;
    private javax.swing.JPanel pnlLineCRound2toRound3;
    private javax.swing.JPanel pnlLineDRound2;
    private javax.swing.JPanel pnlLineDRound2toRound3;
    private javax.swing.JPanel pnlLineJoinAB;
    private javax.swing.JPanel pnlLineJoinABCD;
    private javax.swing.JPanel pnlLineJoinCD;
    private javax.swing.JPanel pnlRound2AB;
    private javax.swing.JPanel pnlRound2BA;
    private javax.swing.JPanel pnlRound2CD;
    private javax.swing.JPanel pnlRound2DC;
    private javax.swing.JPanel pnlRound3AB;
    private javax.swing.JPanel pnlRound3CD;
    // End of variables declaration//GEN-END:variables
}
