package top.musuixin.Service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.musuixin.Mapper.InfoDao;
import top.musuixin.PoJo.InfoPolo;
import top.musuixin.Service.InfoService;

/**
 * @author musuixin
 * @date 2019-03-29 11:14
 */


@Service
@Transactional
public class InfoServiceimpl implements InfoService {
    @Autowired
    InfoDao infoDao;
    @Override
    public void insertInfo(InfoPolo infoPolo) {
        infoDao.insertInfo(infoPolo);
    }
    @Override
    public void deleteInfo(InfoPolo infoPolo) {
        infoDao.deleteInfo(infoPolo);
    }

    @Override
    public void updateInfo(InfoPolo infoPolo) {
        infoDao.updateInfo(infoPolo);
    }
}
