/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.beinlich.markus.musicsystem.gui;

import de.beinlich.markus.musicsystem.model.net.MusicSystemControllerInterface;
import de.beinlich.markus.musicsystem.model.*;
import de.beinlich.markus.musicsystem.model.net.MusicServer;
import java.awt.event.*;
import java.util.Enumeration;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 *
 * @author Markus Beinlich
 */
public class MusicServerApp extends javax.swing.JFrame implements VolumeObserver, TrackTimeObserver, TrackObserver, StateObserver, RecordObserver, MusicPlayerObserver {

    private MusicSystemInterface musicSystem;
    private MusicSystemControllerInterface musicSystemController;
//    private RecordCollection rc;
//    private RecordCollection cdc;
    private final TrackListModel tlm;
    private final RecordComboBoxModel rcm;
//    private static String serverName;
    private MusicServer ms;

    /**
     * Creates new form Player
     */
    public MusicServerApp(MusicSystemControllerInterface musicSystemController, MusicSystem musicSystem) {
        //MusicServer - Daten laden und Model anlegen aber Server noch nicht starten
        //das darf erst nach der Swing-Komponente erfolgen.
        ms = new MusicServer(musicSystemController, musicSystem);
        ms.execute();

        this.musicSystem = musicSystem;
        this.musicSystemController = musicSystemController;

        musicSystem.registerObserver((VolumeObserver) this);
        musicSystem.registerObserver((TrackTimeObserver) this);
        musicSystem.registerObserver((TrackObserver) this);
        musicSystem.registerObserver((StateObserver) this);
        musicSystem.registerObserver((RecordObserver) this);
        musicSystem.registerObserver((MusicPlayerObserver) this);
        
        tlm = new TrackListModel(musicSystem.getRecord());
        rcm = new RecordComboBoxModel(ms.getMusicCollection());

        initComponents();
        //RadioButton's für MusicPlayer initialisieren
        updateMusicPlayer();

        /* Create and display the form */
        this.setVisible(true);
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                this.setVisible(true);
//            }
//        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroupSource = new javax.swing.ButtonGroup();
        buttonPlay = new javax.swing.JButton();
        buttonNext = new javax.swing.JButton();
        buttonPrevious = new javax.swing.JButton();
        buttonPause = new javax.swing.JButton();
        buttonStop = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        rbS1 = new javax.swing.JRadioButton();
        rbS2 = new javax.swing.JRadioButton();
        rbS3 = new javax.swing.JRadioButton();
        rbS4 = new javax.swing.JRadioButton();
        labelElapsedTime = new javax.swing.JLabel();
        labelRemainingTime = new javax.swing.JLabel();
        sliderProgress = new javax.swing.JSlider();
        jLabel2 = new javax.swing.JLabel();
        labelCurrentTrack = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listCurrentRecord = new javax.swing.JList<>();
        jLabel3 = new javax.swing.JLabel();
        sliderVolume = new javax.swing.JSlider();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        comboBoxRecords = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle(musicSystem.getName() + " - " + musicSystem.getLocation());

        buttonPlay.setText("Play");
        buttonPlay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonPlayActionPerformed(evt);
            }
        });

        buttonNext.setText("Next");
        buttonNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonNextActionPerformed(evt);
            }
        });

        buttonPrevious.setText("Previous");
        buttonPrevious.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonPreviousActionPerformed(evt);
            }
        });

        buttonPause.setText("Pause");
        buttonPause.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonPauseActionPerformed(evt);
            }
        });

        buttonStop.setText("Stop");
        buttonStop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonStopActionPerformed(evt);
            }
        });

        jLabel1.setText("Source:");

        buttonGroupSource.add(rbS1);
        rbS1.setSelected(true);
        rbS1.setText("s1");
        rbS1.setActionCommand("S1");
        rbS1.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        rbS1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                rbS1ItemStateChanged(evt);
            }
        });

        buttonGroupSource.add(rbS2);
        rbS2.setText("s2");
        rbS2.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        rbS2.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                rbS2ItemStateChanged(evt);
            }
        });

        buttonGroupSource.add(rbS3);
        rbS3.setText("s3");
        rbS3.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        rbS3.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                rbS3ItemStateChanged(evt);
            }
        });

        buttonGroupSource.add(rbS4);
        rbS4.setText("s4");
        rbS4.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        rbS4.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                rbS4ItemStateChanged(evt);
            }
        });

        labelElapsedTime.setText("-");

        labelRemainingTime.setText("-");

        sliderProgress.setToolTipText("");
        sliderProgress.setValue(0);

        jLabel2.setText("Current Track: ");

        labelCurrentTrack.setText("-");

        listCurrentRecord.setModel(tlm);
        listCurrentRecord.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        listCurrentRecord.setVisibleRowCount(4);
        listCurrentRecord.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listCurrentRecordMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(listCurrentRecord);

        jLabel3.setText("Current Record:");

        sliderVolume.setValue(10);
        sliderVolume.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sliderVolumeStateChanged(evt);
            }
        });

        jLabel4.setText("Volume:");

        jLabel5.setText("Record:");

        comboBoxRecords.setModel(rcm);
        comboBoxRecords.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboBoxRecordsItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel4))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addComponent(jLabel1))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel5)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(rbS1)
                                    .addComponent(rbS2)
                                    .addComponent(rbS4)
                                    .addComponent(rbS3)))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(comboBoxRecords, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(sliderVolume, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(0, 171, Short.MAX_VALUE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(labelElapsedTime)
                                .addGap(18, 18, 18)
                                .addComponent(sliderProgress, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(labelRemainingTime))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(buttonPlay)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(buttonNext)
                                        .addGap(2, 2, 2)
                                        .addComponent(buttonPrevious)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(buttonPause)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(buttonStop))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(labelCurrentTrack, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(rbS1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rbS2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rbS3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rbS4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(comboBoxRecords, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(sliderVolume, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(labelCurrentTrack))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(labelElapsedTime)
                        .addComponent(labelRemainingTime))
                    .addComponent(sliderProgress, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonNext)
                    .addComponent(buttonPlay)
                    .addComponent(buttonPrevious)
                    .addComponent(buttonPause)
                    .addComponent(buttonStop)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonPlayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonPlayActionPerformed
        musicSystemController.play();
    }//GEN-LAST:event_buttonPlayActionPerformed

    private void buttonNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonNextActionPerformed
        musicSystemController.next();
    }//GEN-LAST:event_buttonNextActionPerformed

    private void buttonPreviousActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonPreviousActionPerformed
        musicSystemController.previous();
    }//GEN-LAST:event_buttonPreviousActionPerformed

    private void buttonPauseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonPauseActionPerformed
        musicSystemController.pause();
    }//GEN-LAST:event_buttonPauseActionPerformed

    private void buttonStopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonStopActionPerformed
        musicSystemController.stop();
    }//GEN-LAST:event_buttonStopActionPerformed

    private void sliderVolumeStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sliderVolumeStateChanged
        System.out.println("sliderVolumeStateChanged:" + evt.getSource());
        musicSystemController.setVolume(sliderVolume.getValue());
    }//GEN-LAST:event_sliderVolumeStateChanged

    private void listCurrentRecordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listCurrentRecordMouseClicked
        musicSystemController.setCurrentTrack(listCurrentRecord.getSelectedValue());
    }//GEN-LAST:event_listCurrentRecordMouseClicked

    private void rbS1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_rbS1ItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            musicSystemController.setActiveSource(rbS1.getText());
        }
    }//GEN-LAST:event_rbS1ItemStateChanged

    private void rbS2ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_rbS2ItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            musicSystemController.setActiveSource(rbS2.getText());
        }
    }//GEN-LAST:event_rbS2ItemStateChanged

    private void rbS3ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_rbS3ItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            musicSystemController.setActiveSource(rbS3.getText());
        }
    }//GEN-LAST:event_rbS3ItemStateChanged

    private void rbS4ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_rbS4ItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            musicSystemController.setActiveSource(rbS4.getText());
        }
    }//GEN-LAST:event_rbS4ItemStateChanged

    private void comboBoxRecordsItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboBoxRecordsItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            musicSystemController.setRecord((Record) comboBoxRecords.getSelectedItem());
        }
    }//GEN-LAST:event_comboBoxRecordsItemStateChanged

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroupSource;
    private javax.swing.JButton buttonNext;
    private javax.swing.JButton buttonPause;
    private javax.swing.JButton buttonPlay;
    private javax.swing.JButton buttonPrevious;
    private javax.swing.JButton buttonStop;
    private javax.swing.JComboBox<Record> comboBoxRecords;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelCurrentTrack;
    private javax.swing.JLabel labelElapsedTime;
    private javax.swing.JLabel labelRemainingTime;
    private javax.swing.JList<PlayListComponent> listCurrentRecord;
    private javax.swing.JRadioButton rbS1;
    private javax.swing.JRadioButton rbS2;
    private javax.swing.JRadioButton rbS3;
    private javax.swing.JRadioButton rbS4;
    private javax.swing.JSlider sliderProgress;
    private javax.swing.JSlider sliderVolume;
    // End of variables declaration//GEN-END:variables

    class TrackListModel extends DefaultListModel<PlayListComponent> {

        private Record record;

        public TrackListModel(Record record) {
            this.record = record;
        }

        public void replaceRecord(Record record) {
            this.record = record;
            this.fireContentsChanged(this, 0, getSize() - 1);
        }

        @Override
        public int getSize() {
            if (record == null) {
                return 0;
            }
            return record.getTracks().size();
        }

        @Override
        public PlayListComponent getElementAt(int index) {
//            System.out.println(System.currentTimeMillis() + "getElementAt" + index + record.getTracks().get(index));
            return record.getTracks().get(index);
        }

    }

    class RecordComboBoxModel extends DefaultComboBoxModel<Record> {

        private MusicCollection rc;

        public RecordComboBoxModel(MusicCollection rc) {
            this.rc = rc;
            this.setSelectedItem(rc.getRecord(0));
        }

        public void replaceRecordCollection(MusicCollection rc) {
            this.rc = rc;
        }

        @Override
        public int getSize() {
            return rc.getRecords().size();
        }

        @Override
        public Record getElementAt(int index) {
            return rc.getRecord(index);
        }

    }

    @Override
    public void updateRecord() {

        if (listCurrentRecord != null) {
            listCurrentRecord.clearSelection(); //erzeugt eine Nullpointerexception
        }
        if (comboBoxRecords.getSelectedItem() != null) {
            tlm.replaceRecord((Record) comboBoxRecords.getSelectedItem());
        }
        comboBoxRecords.setSelectedItem(musicSystem.getRecord());

        System.out.println(System.currentTimeMillis() + "updateRecord: " + musicSystem.getRecord() + musicSystem.getCurrentTrack());

        updateTrack();
    }

    @Override
    public void updateState() {
        switch (musicSystem.getMusicSystemState()) {
            case PLAY:
                buttonPlay.setEnabled(false);
                buttonStop.setEnabled(true);
                if (musicSystem.hasPause()) {
                    buttonPause.setEnabled(true);
                }
                break;
            case STOP:
                buttonPlay.setEnabled(true);
                buttonStop.setEnabled(false);
                buttonPause.setEnabled(false);
                break;
            case PAUSE:
                buttonPlay.setEnabled(true);
                buttonStop.setEnabled(true);
                buttonPause.setEnabled(false);
                break;
            default:
                throw new AssertionError("updateState: unknown state " + musicSystem.getMusicSystemState());
        }
    }

    /**
     *
     */
    @Override
    public void updateTrack() {
        if (musicSystem.getCurrentTrack() != null) {
            listCurrentRecord.setSelectedValue(musicSystem.getCurrentTrack(), true);
            labelCurrentTrack.setText(musicSystem.getCurrentTrack().getTitle() + " : " + musicSystem.getCurrentTrack().getPlayingTime());
            sliderProgress.setMinimum(0);
            sliderProgress.setMaximum(musicSystem.getCurrentTrack().getPlayingTime());
        }
        updateTrackTime();
    }

    /**
     *
     */
    @Override
    public void updateTrackTime() {
        labelElapsedTime.setText("- " + musicSystem.getCurrentTimeTrack());
        labelRemainingTime.setText(" " + (musicSystem.getCurrentTrack().getPlayingTime() - musicSystem.getCurrentTimeTrack()));
        sliderProgress.setValue((int) musicSystem.getCurrentTimeTrack());
    }

    @Override
    public void updateVolume() {
        sliderVolume.setValue((int) musicSystem.getVolume());
    }

    /**
     *
     */
    @Override
    public void updateMusicPlayer() {
        int i = 0;
        MusicPlayer ms;
        JRadioButton rb;
        System.out.println(System.currentTimeMillis() + "UpdateMusicPlayer");
        int anz = musicSystem.getSources().size();
        for (Enumeration<AbstractButton> rbg = buttonGroupSource.getElements(); rbg.hasMoreElements();) {
            //        for (MusicPlayer ms : hifi.getSources().) {
            rb = (JRadioButton) rbg.nextElement();
            if (i < anz) {
                ms = musicSystem.getSources().get(i);
                rb.setVisible(true);
                rb.setText(ms.getTitle());
                //Werte der aktiven MusicPlayer anzeigen
                if (ms == musicSystem.getActivePlayer()) {
                    rb.setSelected(true);
                    comboBoxRecords.updateUI(); // wird benötigt, damit auch größere Listen platz haben 
                    //da sich die MusicPlayer ändert müssen die Observer, die an der MusiicSource hängen neu registriert werden.
                    //das stimmt doch gar nicht. Die Observer hängen doch an der MusicApp -> nein. Sie werden von dort an die activeSource gehängt
                    musicSystem.registerObserver((TrackObserver) this);
                    musicSystem.registerObserver((StateObserver) this);
                    musicSystem.registerObserver((TrackTimeObserver) this);
                    musicSystem.registerObserver((VolumeObserver) this);
                    musicSystem.registerObserver((RecordObserver) this);

                    //Achtung - hier muss noch die passende MusicColleciton geladen werden.
                    //Das ist keine tolle Lösung mir fällt nichts besseres ein.
                    //Ich will vermeiden, das die MusicCollection an der MusicPlayer hängt.
                    switch (musicSystem.getActivePlayer().getClass().getSimpleName()) {
                        case "CdPlayer":
                            rcm.replaceRecordCollection(CdCollection.getInstance());
                            break;
                        case "Mp3Player":
                            rcm.replaceRecordCollection(Mp3Collection.getInstance());
                            break;
                        case "RecordPlayer":
                            rcm.replaceRecordCollection(RecordCollection.getInstance());
                            break;
                        case "Radio":
                            rcm.replaceRecordCollection(RadioStationCollection.getInstance());
                            break;
                        default:
                            System.err.println("Unbekannte Klasse der ActiveSource: " + musicSystem.getClass().getSimpleName());
                    }
                    //Selektierten Record auf ersten Wert der Liste setzen
                    //Das darf erst erfolgen, wenn die neue RecordCollection gesetzt ist.
                    comboBoxRecords.setSelectedIndex(0);
                    buttonNext.setEnabled(musicSystem.hasNext());
                    buttonPrevious.setEnabled(musicSystem.hasPrevious());
                    buttonPause.setEnabled(musicSystem.hasPause());
                    sliderProgress.setEnabled(musicSystem.hasCurrentTime());
                    jScrollPane1.setEnabled(musicSystem.hasTracks());
                    listCurrentRecord.setEnabled(musicSystem.hasTracks());
                }
            } else {
                rb.setVisible(false);
            }
            rb.repaint();
            System.out.println(System.currentTimeMillis() + "Radiobutton:" + rb.getText());
            i++;
        }

    }

}
