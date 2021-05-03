package springbootstarter.topic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController		//@RestController automatically convert the return type into JSON format
public class TopicController {

	@Autowired
	private TopicService topicService;

	@RequestMapping("/topics")
	public List<Topic> getAllTopics() {
		return topicService.getAllTopics();
	}

	@RequestMapping("/topics/{id}")
	//@PathVariable is sufficient if the variable name is same in @RequestMapping and function argument
	public Topic getTopic(@PathVariable("id") String id) {
		return topicService.getTopic(id);
	}

	@RequestMapping(method=RequestMethod.POST, value="/topics")
	public void addTopic(@RequestBody Topic topic) {
		topicService.addTopic(topic);
	}

	@RequestMapping(method=RequestMethod.PUT, value="/topics/{id}")
	public Topic updateTopic(@RequestBody Topic topic, @PathVariable String id) {
		return topicService.updateTopic(id,topic);
	}

	@RequestMapping(method=RequestMethod.DELETE, value="/topics/{id}")
	public Topic deleteTopic(@PathVariable String id) {
		return topicService.deleteTopic(id);
	}
}
