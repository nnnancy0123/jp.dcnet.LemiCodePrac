package jdbcPr;

import java.util.List;

public class JdbcService {

	public void addPerson(List<JdbcObj> list) {

		Jdbcdao dao = new Jdbcdao();
		dao.addPerson(list);

	}

}