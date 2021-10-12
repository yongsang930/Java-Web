package board;

import java.util.List;

public class ServiceImpl implements Service {

	Dao dao = new DaoImpl();

	@Override
	public void write(Board b) {
		dao.insert(b);
	}

	@Override
	public Board getArticle(int num) {
		return null;
	}

	@Override
	public List getArticles() {
		return null;
	}

	@Override
	public void editArticle(Board b) {
	}

	@Override
	public void delArticle(int num) {
	}
}
