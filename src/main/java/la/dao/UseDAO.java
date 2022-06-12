package la.dao;

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
	
}
