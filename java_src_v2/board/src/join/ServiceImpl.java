package join;

public class ServiceImpl implements Service {
	Dao dao;

	public ServiceImpl() {
		dao = new DaoOracleImpl();
	}

	@Override
	public boolean addMember(Member m) {

		if (dao.insertMerber(m) <= 0)
			return false;
		else
			return true;
	}

	@Override
	public boolean editMemberInfo(Member m) {

		if (dao.updateMember(m) <= 0)
			return false;
		else
			return false;
	}

	@Override
	public boolean removeMember(String id) {

		if (dao.removerMember(id) <= 0)
			return false;
		else
			return true;
	}

	@Override
	public boolean login(String id, String pwd) {

		return dao.login(id, pwd);
	}

	@Override
	public Member getMember(String id) {
		// TODO Auto-generated method stub
		return null;
	}

}
