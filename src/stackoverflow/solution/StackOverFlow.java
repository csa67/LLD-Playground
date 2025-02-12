package stackoverflow.solution;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class StackOverFlow {
    private final Map<Integer, User> users;
    private final Map<Integer, Question> questions;
    private final Map<Integer, Answer> answers;
    private final Map<String, Tag> tags;

    public StackOverFlow() {
        users = new ConcurrentHashMap<>();
        questions = new ConcurrentHashMap<>();
        answers = new ConcurrentHashMap<>();
        tags = new ConcurrentHashMap<>();
    }

    public User createUser(String username, String email){
        int id= users.size()+1;
        User user = new User(id, username,email);
        users.put(id, user);
        return user;
    }

    public Question createQuestion(String content, User user, String title, List<String> tags){
        Question question = new Question(title,content, user, tags);
        questions.put(question.getId(),question);
        for (Tag tag : question.getTags()) {
            this.tags.putIfAbsent(tag.getName(), tag);
        }
        return question;
    }

    public Answer answerQuestion(Question question, User user, String content){
        Answer answer = new Answer(question,user,content);
        answers.put(answer.getId(),answer);
        return answer;
    }

    public Comment addComment(User user, Commentable commentable, String content) {
        return user.addComment(content,commentable);
    }

    public void voteQuestion(Question question, User user, int vote) {
        question.vote(user,vote);
    }

    public void voteAnswer(Answer answer, User user, int vote) {
        answer.vote(user,vote);
    }

    public void acceptAnswer(Answer answer){
        answer.markAsAccepted();
    }

    public List<Question> getQuestionsByUser(User user){
        return user.getQuestions();
    }

    public List<Question> searchQuestions(String query){
        return questions.values().stream()
                .filter(
                        q -> q.getTitle().toLowerCase().contains(query.toLowerCase()) ||
                                q.getContent().toLowerCase().contains(query.toLowerCase()) ||
                                q.getTags().stream().anyMatch(t-> t.getName().equalsIgnoreCase(query))

                ).collect(Collectors.toList());
    }
}
