package la.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import la.bean.TicketKindBean;
import la.bean.VisitorBean;

public class TicketKindDAO {
	private String url = "jdbc:postgresql:postgres";
	private String user = "user1";
	private String pass = "himitu";
	
	public TicketKindDAO() throws DAOException {
		try {
			Class.forName("org.postgresql.Driver");
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new DAOException("JDBCドライバの登録に失敗しました。");
		}
	}
	
	public List<TicketKindBean> findTicketKind() throws DAOException {
		
		String sql = "SELECT * FROM ticket ORDER BY ticket_id";
		
		try (
				Connection con = DriverManager.getConnection(url, user, pass);
				PreparedStatement st = con.prepareStatement(sql);
				ResultSet rs = st.executeQuery();
				) {
			
			List<TicketKindBean> list = new ArrayList<TicketKindBean>();
			while (rs.next()) {
				int ticketId = rs.getInt("ticket_id");
				String ticketName = rs.getString("ticket_name");
				int price = rs.getInt("price");
				TicketKindBean bean = new TicketKindBean(ticketId, ticketName, price);
				list.add(bean);
			}
			
			return list;
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("レコードの取得に失敗しました。");
		}
	}
	
	// ticketIdからticketNameを取得
	public String getTicketName(int ticketId) throws DAOException {
		String sql = "SELECT ticket_name FROM ticket WHERE ticket_id = ?";
		try (
				Connection con = DriverManager.getConnection(url, user, pass);
				PreparedStatement st = con.prepareStatement(sql);) {
			
			// プレースホルダの設定
			st.setInt(1, ticketId);
			
			try (ResultSet rs = st.executeQuery();) {
				if (rs.next()) {
					String ticketName = rs.getString("ticket_name");
					return ticketName;
					
				} else {
					return null;
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
				throw new DAOException("レコードの取得に失敗しました。");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("レコードの取得に失敗しました。");
		}
	}
	
	public VisitorBean saveVisitor(int ticketId) throws DAOException {
		
		// 入園者番号を取得
		int visitorId = 0;
		String sql = "SELECT nextval('visitor_visitor_id_seq')";
		try (
				Connection con = DriverManager.getConnection(url, user, pass);
				PreparedStatement st = con.prepareStatement(sql);
				ResultSet rs = st.executeQuery();) {
			
			if (rs.next()) {
				visitorId = rs.getInt(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("レコードの操作に失敗しました。");
		}
		
		// visitorテーブルに入場者情報を格納
		sql = "INSERT INTO visitor VALUES(?, ?, ?, ?, ?)";
		try (
				Connection con = DriverManager.getConnection(url, user, pass);
				PreparedStatement st = con.prepareStatement(sql);) {
			
			// プレースホルダの設定
			st.setInt(1, visitorId);
			st.setInt(2, ticketId);
			st.setString(3, getNowDate());
			st.setString(4, getNowDateTime());
			st.setString(5, null);
			
			// SQL文を実行
			st.executeUpdate();
			VisitorBean bean = new VisitorBean(visitorId, ticketId, getNowDate(), 
					getNowDateTime(), null);
			return bean;
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("レコードの操作に失敗しました。");
		}
	}
	
	// 日付をString型に変換
	private String getNowDate() {
		final DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        final Date date = new Date(System.currentTimeMillis());
        return df.format(date);
	}
	
	// 日付(時刻まで表示)をString型に変換
	private String getNowDateTime() {
		final DateFormat df = new SimpleDateFormat("HH:mm:ss");
        final Date date = new Date(System.currentTimeMillis());
        return df.format(date);
	}
}
