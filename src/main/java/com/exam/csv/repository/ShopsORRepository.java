package com.exam.csv.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.exam.csv.controller.jsonData;
import com.exam.csv.page.ShopInCategory;


@Repository
@Component
public class ShopsORRepository {
	
	public static final RowMapper<ShopInCategory> ShopInCate_RM = (rs, i) -> {
		Integer id = rs.getInt("id");
		String name = rs.getString("name");
		String address = rs.getString("address");
		String detail = rs.getString("detail");
		String categoryName = rs.getString("category_name");
		return new ShopInCategory(id,name, address, detail, categoryName);
	};
	
	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;
	
	/**
	 * staffId値のプロジェクト内の言語情報取得
	 * @author kuro
	 * @return　言語情報情報
	 */
	public List<ShopInCategory> findList(){
			SqlParameterSource param = new MapSqlParameterSource();
			List<ShopInCategory> list = jdbcTemplate.query("select s.*,(select cd.name as category_name from categories_defene cd where cd.id = ce.category_id)"
					+ " from shops s left outer join categories_exp ce on s.id = ce.shop_id order by s.id"
					, param, ShopInCate_RM);
			return list;
	}

	public List<ShopInCategory> findByName(jsonData bean) {
		SqlParameterSource param = new MapSqlParameterSource().addValue("shopName", bean.getName());
		List<ShopInCategory> list = jdbcTemplate.query("select s.*,(select cd.name as category_name from categories_defene cd where cd.id = ce.category_id)"
				+ " from shops s left outer join categories_exp ce on s.id = ce.shop_id where s.name ILIKE '%' || :shopName || '%' order by s.id"
				, param, ShopInCate_RM);
		return list;
	}
	
}
