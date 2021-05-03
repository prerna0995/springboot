package springbootstarter.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TopicService {

	List<Topic> topics =  new ArrayList<Topic>(Arrays.asList(
			new Topic("Spring","Spring Framework","Spring framework Description"),
			new Topic("Spring Boot","Spring Boot Framework","Spring Boot framework Description"),
			new Topic("Java","Core Java","Core Java Description"),
			new Topic("Maven","Maven Installation","Maven Description")));

	public List<Topic> getAllTopics(){
		return topics;
	}

	public Topic getTopic(String id) {
		return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
	}

	public void addTopic(Topic topic) {
		topics.add(topic);
	}
	
	public Topic updateTopic(String id, Topic topic) {
		for(int i=0;i<topics.size();i++) {
			Topic t = topics.get(i);
			if(t.getId().equals(id)) {
				topics.set(i, topic);
				break;
			}
		}
		return topic;
	}

	public Topic deleteTopic(String id) {
		//return topics.removeIf(t -> t.getId().equals(id));
		for(int i=0;i<topics.size();i++) {
			Topic t = topics.get(i);
			if(t.getId().equals(id)) {
				return topics.remove(i);
			}
		}
		return null;
	}
}

