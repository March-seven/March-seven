
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        SimHashService simHashService = new SimHashService();
        if (args.length >= 3) {
            String origPath = args[0];  // 原文文件路径
            String orig_addPath = args[1];  // 抄袭版论文的文件路径
            String resultFilePath = args[2];  // 答案文件路径

            String orig;  // 原文文件
            String orig_add;  // 抄袭版论文的文件
            String resultFile;  // 答案文件

            System.out.println("原文文件路径：" + origPath);
            System.out.println("抄袭版论文的文件路径：" + orig_addPath);

            try {
                //读取原文文件
                byte[] fileBytes = Files.readAllBytes(Paths.get(origPath));
                orig = new String(fileBytes, StandardCharsets.UTF_8);
                System.out.println(orig);

                // 读取抄袭版论文的文件
                fileBytes = Files.readAllBytes(Paths.get(orig_addPath));
                orig_add = new String(fileBytes,StandardCharsets.UTF_8);
                System.out.println(orig_add);

                //调用SimHashService类的compare方法对文本进行查重
                resultFile = simHashService.compare(orig, orig_add);
                System.out.println(resultFile);

                Path outputPath = Paths.get(resultFilePath);
                Files.writeString(outputPath, resultFile);
                System.out.println("查重数据已经保存到文件：" + resultFilePath);
            } catch (IOException e) {
                e.printStackTrace();
            }


        } else {
            System.out.println("请提供至少三个文本地址作为参数。");
        }


    }
}
