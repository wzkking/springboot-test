package org.wt.book.service;

import org.wt.book.model.*;

import java.util.Date;
import java.util.List;



public interface ActiviRecService {
	//根据活动ID和用户id获取 用户做活动记录
	Activirec selectByUidAndTitleId(int uid, Integer id);
	//根据活动ID和用户id获取 用户做活动记录 倒序
	Activirec selectByUidAndTitleIdDesc(int uid, Integer id);
	//根据用户id获取 总获取免费豆
	int SumAward(int uid);
	//根据用户id获取 总获取每日免费豆
	int sumAwardByDate(int userId, Date date);
	//根据用户id获取 获取用户排名
	Rank myRank(int userId);
	//获取所有的用户
	int countUser();
	//添加活动记录
	int add(Activirec activirec);
	//添加订单 和 添加用户任务记录信息
	int insertBeanRec(Order order, Knapsack kna, Activirec activirec);
	//添加订单 和 更新用户任务记录信息
	int insertBeanUpdate(Order order, Knapsack kna, Activirec activirec);
	//获取用户已经邀请好友的数量
	int countTitleFriend(int uid, Integer id);
	//根据用ID和活动id获取用户的 活动记录
	List<Activirec> selectByUserIdAndTitleId(int userId, Integer titleId);
	//添加订单 和用户任务记录信息 添加站内信
	int insertBeanRecMsg(Order order, Knapsack kna, Activirec activirec,
						 Message msg);
	// 用户任务记录信息 添加站内信
	int insertRecMsg(Activirec activirec, Message msg);
	// 添加用户任务记录信息 添加好友邀请记录
	int insertRecFri(Activirec activirec, Friends friends);
	// 根据用户id 和 好友手机号码 获取 活动记录
	Activirec selectByIdFri(Integer sysos, String phone);
	//添加订单 和 更新用户任务记录信息 添加站内信
	int insertBeanUpdateRecMsg(Order order, Knapsack kna, Activirec activirec,
							   Message msg);
}
