package cn.yl.admin.service;

import cn.yl.admin.domain.entity.Staff;
import cn.yl.admin.repository.StaffRepository;
import cn.yl.common.vo.StaffVO;
import org.hibernate.query.internal.NativeQueryImpl;
import org.hibernate.transform.Transformers;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.math.BigInteger;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class StaffServiceImpl implements StaffService {
    @Resource
    private StaffRepository staffRepository;
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public Page<StaffVO> page(Pageable pageable) {
        StringBuilder sql = new StringBuilder("select * from sys_user ");
        StringBuilder count = new StringBuilder("select count(id) from sys_user ");
        Query sqlQuery = entityManager.createNativeQuery(sql.toString());
        Query countQuery = entityManager.createNativeQuery(count.toString());

        sqlQuery.unwrap(NativeQueryImpl.class).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        sqlQuery.setFirstResult((pageable.getPageNumber() - 1) * pageable.getPageSize());
        sqlQuery.setMaxResults((int)pageable.getOffset()-1);
        BigInteger countNum = (BigInteger) countQuery.getSingleResult();
        long total = countNum.longValue();
        List<StaffVO> content;
        List<Map<String,Object>> list = sqlQuery.getResultList();
        if (list.isEmpty()){
            content = Collections.emptyList();
        }else {
            content = list.stream().map(map->{
                StaffVO vo = new StaffVO();
                vo.setId(map.get("id")!=null?Integer.valueOf(map.get("id").toString()):null);
                vo.setUsername(map.get("username")!=null?map.get("username").toString():"");
                vo.setName(map.get("name")!=null?map.get("name").toString():"");
                vo.setSex(map.get("sex")!=null?Integer.valueOf(map.get("sex").toString()):null);
                vo.setStatus(map.get("status")!=null?Integer.valueOf(map.get("status").toString()):null);
                return vo;
            }).collect(Collectors.toList());
        }
        return new PageImpl<>(content, pageable, total);
    }

    @Override
    public StaffVO getStaff(String username) {
        Staff staff = staffRepository.findByUsername(username);
        System.out.println(staff.toString());
        StaffVO staffVO = new StaffVO();
        staffVO.setId(staff.getId());
        staffVO.setUsername(staff.getUsername());
        return staffVO;
    }
}
