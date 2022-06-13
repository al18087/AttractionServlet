package la.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;


public class UseDAO {
	private String url = "jdbc:postgresql:postgres";
	private String user = "user1";
	private String pass = "himitu";
	
	public UseDAO() throws DAOException {
		try {
			Class.forName("org.postgresql.Driver");
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new DAOException("JDBCドライバの登録に失敗しました。");
		}
	}
	
	public Map<String, String> saveUse(int visitorId, int attractionId) throws DAOException {
		String sql = "INSERT INTO use VALUES (?, ?, ?)";
		try (
				Connection con = DriverManager.getConnection(url, user, pass);
				PreparedStatement st = con.prepareStatement(sql);) {
			
			// プレースホルダの設定
			st.setInt(1, visitorId);
			st.setString(2, getNowDateTime());
			st.setInt(3, attractionId);
			st.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("レコードの操作に失敗しました。");
		}
		
		sql = "SELECT attraction_name FROM attraction WHERE attraction_id = ?";
		try (
				Connection con = DriverManager.getConnection(url, user, pass);
				PreparedStatement st = con.prepareStatement(sql);) {
			
			// プレースホルダの設定
			st.setInt(1, attractionId);
			
			try (ResultSet rs = st.executeQuery();) {
				Map<String, String> map = new HashMap<String, String>();
				if (rs.next()) {
					String attractionName = rs.getString("attraction_name");
					map.put(attractionName, getNowDateTime());
					return map;
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
	
	// 日付(時刻まで表示)をString型に変換
	private String getNowDateTime() {
		final DateFormat df = new SimpleDateFormat("HH:mm:ss");
		final Date date = new Date(System.currentTimeMillis());
		return df.format(date);
	}
	
}
