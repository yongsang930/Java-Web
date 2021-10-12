package join;

public interface Dao {
	
	int insertMerber(Member m);
	
	int updateMember(Member m);
	
	int removerMember(String id);
	
	boolean login(String id, String pwd);
	
	Member memberInfo(String id);
	
}
