package com.dao;

        import com.entity.CategoryEntity;
        import org.apache.ibatis.annotations.Param;
        import org.springframework.stereotype.Repository;

        import java.util.List;

/**
 * @author SherWin
 * @date 2019/12/2 11:40
 */
@Repository
public interface CategoryDao {
    void insert(CategoryEntity categoryEntity);
    void deleteById(@Param("cid") Integer cid);
    void update(CategoryEntity categoryEntity);
    List<CategoryEntity> getAll();
}
