package org.wt.book.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.wt.book.dao.ActivirecMapper;
import org.wt.book.model.*;
import org.wt.book.service.ActiviRecService;


@Service
public class ActiviRecServiceImpl implements ActiviRecService {

	@Autowired
	private ActivirecMapper activirecMapper;


	@Override
	public Activirec selectByUidAndTitleId(int uid, Integer id) {
		try {
			List<Activirec> list = activirecMapper.selectByUserIdAndTitleId(uid,id);
			if (!list.isEmpty()) {
				return list.get(0);
			}
		} catch (Exception e) {

		}
		return null;

	}

	@Override
	public Activirec selectByUidAndTitleIdDesc(int uid, Integer id) {
		// TODO Auto-generated method stub
		return activirecMapper.selectByUidAndTitleIdDesc(uid, id);
	}

	@Override
	public int SumAward(int uid) {
		// TODO Auto-generated method stub
		return activirecMapper.sumAward(uid);
	}

	@Override
	public int sumAwardByDate(int userId, Date date) {
		// TODO Auto-generated method stub
		return activirecMapper.sumAwardByDate(userId, date);
	}

	@Override
	public Rank myRank(int userId) {
		// TODO Auto-generated method stub
		return activirecMapper.myRank(userId);
	}

	@Override
	public int countUser() {
		// TODO Auto-generated method stub
		return activirecMapper.countUser();
	}

	@Override
	public int add(Activirec activirec) {
		// TODO Auto-generated method stub
		return activirecMapper.insert(activirec);
	}

	@Override
	public int insertBeanRec(Order order, Knapsack kna, Activirec activirec) {
		// TODO Auto-generated method stub
		int result = 0;

/*		if (null != order) {
			result += orderMapper.insertSelective(order);
		}
		if (null != kna) {
			result += knapsackMapper.insertSelective(kna);
		}*/
		if (null != activirec) {
			result += activirecMapper.insert(activirec);
		}
		return result;
	}

	@Override
	public int insertBeanUpdate(Order order, Knapsack kna, Activirec activirec) {
		// TODO Auto-generated method stub
		int result = 0;

/*		if (null != order) {
			result += orderMapper.insertSelective(order);
		}
		if (null != kna) {
			result += knapsackMapper.insertSelective(kna);
		}*/
		if (null != activirec) {
			result += activirecMapper.updateByPrimaryKey(activirec);
		}
		return result;
	}

	@Override
	public int countTitleFriend(int uid, Integer id) {
		// TODO Auto-generated method stub
		ActivirecExample example = new ActivirecExample();
		ActivirecExample.Criteria criteria = example.createCriteria();
		criteria.andUserIdEqualTo(uid);
		criteria.andTitleIdEqualTo(id);
		int sum = (int) activirecMapper.countTitleFriend(uid,id);
		return sum;
	}

	@Override
	public List<Activirec> selectByUserIdAndTitleId(int userId, Integer titleId) {
		// TODO Auto-generated method stub
		ActivirecExample example = new ActivirecExample();
		ActivirecExample.Criteria criteria = example.createCriteria();
		criteria.andUserIdEqualTo(userId);
		criteria.andTitleIdEqualTo(titleId);
		try {
			List<Activirec> list = activirecMapper.selectByUserIdAndTitleId(1,1);
			if (!list.isEmpty()) {
				return list;
			}
		} catch (Exception e) {

		}
		return null;
	}

	@Override
	public int insertBeanRecMsg(Order order, Knapsack kna, Activirec activirec,
			Message msg) {
		// TODO Auto-generated method stub
		int result = 0;

/*		if (null != order) {
			result += orderMapper.insertSelective(order);
		}
		if (null != kna) {
			result += knapsackMapper.insertSelective(kna);
		}*/
		if (null != activirec) {
			result += activirecMapper.insert(activirec);
		}
/*		if (null != msg) {
			result += messageMapper.insert(msg);
		}*/
		return result;
	}

	@Override
	public int insertRecMsg(Activirec activirec, Message msg) {
		// TODO Auto-generated method stub
		int result = 0;
		if (null != activirec) {
			result += activirecMapper.insert(activirec);
		}
/*		if (null != msg) {
			result += messageMapper.insert(msg);
		}*/
		return result;
	}

	@Override
	public int insertRecFri(Activirec activirec, Friends friends) {
		// TODO Auto-generated method stub
		int result = 0;
		if (null != activirec) {
			result += activirecMapper.insert(activirec);
		}
/*		if (null != friends) {
			result += friendsMapper.insert(friends);
		}*/
		return result;
	}

	@Override
	public Activirec selectByIdFri(Integer userId, String phone) {
		// TODO Auto-generated method stub
		ActivirecExample example = new ActivirecExample();
		ActivirecExample.Criteria criteria = example.createCriteria();
		criteria.andUserIdEqualTo(userId);
		criteria.andStr2EqualTo(phone);
		try {
			List<Activirec> list = activirecMapper.selectByUserIdAndTitleId(1,1);
			if (!list.isEmpty()) {
				return list.get(0);
			}
		} catch (Exception e) {

		}
		return null;
	}

	@Override
	public int insertBeanUpdateRecMsg(Order order, Knapsack kna,
			Activirec activirec, Message msg) {
		// TODO Auto-generated method stub
		int result = 0;

/*		if (null != order) {
			result += orderMapper.insertSelective(order);
		}
		if (null != kna) {
			result += knapsackMapper.insertSelective(kna);
		}*/
		if (null != activirec) {
			result += activirecMapper.updateByPrimaryKey(activirec);
		}
/*		if (null != msg) {
			result += messageMapper.insert(msg);
		}*/
		return result;
	}

}
