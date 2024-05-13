package com.example.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.domain.Administrator;

//
@Repository
public class AdministratorRepository {

@Autowired
private NamedParameterJdbcTemplate template;

    //RowMapperをフィールド部にラムダ式で定義
    private static final RowMapper<Administrator> ADMINISTRATOR_ROW_MAPPERR = (rs, i)->{
        Administrator administrator = new Administrator();
        administrator.setId(rs.getInt("id"));
        administrator.setName(rs.getString("name"));
        administrator.setMailAddress(rs.getString("mailAddress"));
        administrator.setPassword(rs.getString("password"));
        return administrator;
    };


    //管理者情報の挿入
    public void insert(Administrator administrator){
        String sql="Select id, name, mail_address, password FROM administrators";
    }


    //メールアドレスとパスワードから管理者情報を取得する(1件も存在しない場合は null を返す※)。
    public Administrator findByMailAddressAndPassword(String mailAddress, String password){
        
        List<Administrator> administratorList = template.query(sql, ADMINISTRATOR_ROW_MAPPER); 
        if(administratorList.size() == 0) {
            return null; 
        }
        return administratorList.get(0);
    }

}
