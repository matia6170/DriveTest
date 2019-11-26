/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

//import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import java.util.ArrayList;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  private DifferentialDrive drive;  
  private XboxController pilot;
  private SpeedControllerGroup m_left;
  private SpeedControllerGroup m_right;

  private ArrayList<Victor> motorsLeft = new ArrayList<Victor>();
  private ArrayList<Victor> motorsRight = new ArrayList<Victor>();


  /**
   * This function is run when the robot is first started up and should be
   * used for any initialization code.
   */
  @Override
  public void robotInit() {

    motorsLeft.add(new Victor(0));
    motorsLeft.add(new Victor(1));
    motorsLeft.add(new Victor(2));

    motorsRight.add(new Victor(3));
    motorsRight.add(new Victor(4));
    motorsRight.add(new Victor(5));


       pilot = new XboxController(0);
       /*
        m_left = new SpeedControllerGroup(new SpeedControllerGroup(motorsLeft.get(0), motorsLeft.get(1), motorsLeft.get(2)));
       m_right = new SpeedControllerGroup(new SpeedControllerGroup(motorsRight.get(3), motorsRight.get(4), motorsRight.get(5)));
    */
       m_left = new SpeedControllerGroup(new SpeedControllerGroup(new Victor(0), new Victor(1)), new Victor(2));
       m_right = new SpeedControllerGroup(new SpeedControllerGroup(new Victor(3), new Victor(4)), new Victor(5));

      
       drive = new DifferentialDrive(m_left, m_right);
  }

  /**
   * This function is called every robot packet, no matter the mode. Use
   * this for items like diagnostics that you want ran during disabled,
   * autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before
   * LiveWindow and SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {
    drive.arcadeDrive(pilot.getY(Hand.kLeft), -pilot.getX(Hand.kRight), true);
    


  }

  /**
   * This autonomous (along with the chooser code above) shows how to select
   * between different autonomous modes using the dashboard. The sendable
   * chooser code works with the Java SmartDashboard. If you prefer the
   * LabVIEW Dashboard, remove all of the chooser code and uncomment the
   * getString line to get the auto name from the text box below the Gyro
   *
   * <p>You can add additional auto modes by adding additional comparisons to
   * the switch structure below with additional strings. If using the
   * SendableChooser make sure to add them to the chooser code above as well.
   */
  @Override
  public void autonomousInit() {

  }

  /**
   * This function is called periodically during autonomous.
   */
  @Override
  public void autonomousPeriodic() {

    
  }

  /**
   * This function is called periodically during operator control.
   */
  @Override
  public void teleopPeriodic() {
  }

  /**
   * This function is called periodically during test mode.
   */
  @Override
  public void testPeriodic() {
  }
}