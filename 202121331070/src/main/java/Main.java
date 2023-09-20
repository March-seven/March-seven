public class Main {
    public static void main(String[] args) {
        SimHashService simHashService = new SimHashService();
        String result = simHashService.compare("今天是星期天，天气晴，今天晚上我要去看电影", "今天是周天，天气晴朗，我晚上要去看电影");
        System.out.println(result);
    }
}
