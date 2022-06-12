package la.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDAO {
	private String url = "jdbc:postgresql:postgres";
	private String user = "user1";
	private String pass = "himitu";
	
	public LoginDAO() throws DAOException {
		try {
			Class.forName("org.postgresql.Driver");
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new DAOException("JDBCドライバの登録に失敗しました。");
		}
	}
	
	public Integer findVisitorId(int Id) throws DAOException {
		String sql = "SELECT visitor_id FROM visitor WHERE visitor_id = ?";
		try (
				Connection con = DriverManager.getConnection(url, user, pass);
				PreparedStatement st = con.prepareStatement(sql);) {
			
			// プレースホルダの設定
			st.setInt(1, Id);
			
			try (ResultSet rs = st.executeQuery();) {
				if (rs.next()) {
					int visitorId = rs.getInt("visitor_id");
					return visitorId;
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
}
