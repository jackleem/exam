package com.free.exam.dao;

import com.free.exam.model.Package;
import com.free.exam.orm.EzOrm;
import com.free.exam.orm.impl.EzOrmBaseDao;
import org.springframework.stereotype.Component;

/**
 * Created by Li Yu on 2017/6/13.
 */
@Component
public class PackageDao extends EzOrmBaseDao<Package> implements EzOrm<Package> {

}
