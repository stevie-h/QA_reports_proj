package com.example.demo;

import java.sql.*;
import java.util.ArrayList;

public class ReportREPO
{
    private String m_conn;

    public ReportREPO(String m_conn)
    {
        this.m_conn = m_conn;
    }

    public void setM_conn(String m_conn)
    {
        this.m_conn = m_conn;
    }

    public ArrayList<ReportDTO> getAllReports()
    {
        ArrayList<ReportDTO> m_reports = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(m_conn))
        {
            if(conn != null)
            {
                String sql = "SELECT * FROM Reports";
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql);

                while (rs.next())
                {
                    ReportDTO rep = new ReportDTO(
                            rs.getInt("Id"),
                            rs.getString("License_Plate"),
                            rs.getInt("Driver_Id"),
                            rs.getInt("Speed"));
                    m_reports.add(rep);
                }
            }
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return m_reports;
    }

    public ReportDTO getReportById(int id)
    {
        try (Connection conn = DriverManager.getConnection(m_conn))
        {
            if(conn != null)
            {
                String sql = "SELECT * FROM Reports WHERE Id = " + id;
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                while (rs.next())
                {
                    ReportDTO rep = new ReportDTO(
                            rs.getInt("Id"),
                            rs.getString("License_Plate"),
                            rs.getInt("Driver_Id"),
                            rs.getInt("Speed"));
                    return rep;
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public void insertReport(ReportDTO report)
    {
        try (Connection conn = DriverManager.getConnection(m_conn))
        {
            if(conn != null)
            {
                String sql = String.format("INSERT INTO Reports (Id, License_Plate, Driver_Id, Speed)" +
                                " VALUES ('%d', '%s', '%d', '%d')", report.getM_id(),
                        report.getM_license_plate(), report.getM_driver_id(),
                        report.getM_speed());
                Statement stmt = conn.createStatement();
                stmt.executeUpdate(sql);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void updateReport(ReportDTO report, int id)
    {
        try (Connection conn = DriverManager.getConnection(m_conn))
        {
            if(conn != null)
            {
                String sql = String.format("UPDATE Reports SET " +
                                "License_Plate = '%s', " +
                                "Driver_Id = %d, " +
                                "Speed = %d " +
                                "WHERE Id = %d", report.getM_license_plate(), report.getM_driver_id(),
                        report.getM_speed(), id);
                Statement stmt = conn.createStatement();
                stmt.executeUpdate(sql);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void deleteReport(int id)
    {
        try (Connection conn = DriverManager.getConnection(m_conn))
        {
            if(conn != null)
            {
                String sql = "DELETE FROM Reports WHERE Id = " + id;
                Statement stmt = conn.createStatement();
                stmt.executeUpdate(sql);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


}
