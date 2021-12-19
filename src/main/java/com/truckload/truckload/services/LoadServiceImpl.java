package com.truckload.truckload.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.truckload.truckload.dao.LoadDao;
import com.truckload.truckload.entities.Load;

@Service
public class LoadServiceImpl implements LoadService{
	
	@Autowired
	private LoadDao loadDao;

//	List<Course> list;
	
	public LoadServiceImpl() {
//		list = new ArrayList<>();
//		list.add(new Course(145, "Java Core Courses", "This course is for newbies"));	
//		list.add(new Course(146, "Go Core Courses", "This course is for advanced"));
//	
	}
	@Override
	public List<Load> getLoads(long shipperId) {
		return loadDao.findElementByShipperId(shipperId);
	}

	@Override
	public Load getLoad(long loadId) {
//		Course c = null;
//		for(Course course:list) {
//			if(course.getId() == courseId) {
//				c = course;
//				break;
//			}
//		}
		return loadDao.findById(loadId).get();
		
	}	

	@Override
	public Load addLoad(Load load) {
//		list.add(course);
		loadDao.save(load);
		return load;
	}

	@Override
	public void updateLoad(Load load) {
		
//		list.forEach(e -> {
//			if(e.getId() == course.getId()) {
//				e.setTitle(course.getTitle());
//				e.setDescription(course.getDescription());
//			}
//		});
		loadDao.save(load);
	}

	@Override
	public void deleteLoad(long parseLong) {
//		list=this.list.stream().filter(e->e.getId()!=parseLong).collect(Collectors.toList());
		@SuppressWarnings("deprecation")
		Load entity = loadDao.getOne(parseLong);
		loadDao.delete(entity);
	}

}
