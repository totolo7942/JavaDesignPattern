package behavioral_design_pattern.strategy;

import java.util.Map;

public class FileParserSrategyPatternMain {
    public static void main(String[] args) {
        FileParserStrageyService fileParserStrageyService = new FileParserStrageyService();
        IFileParserStrategy iFileParserStrategy = fileParserStrageyService.getParser(FileTypes.JSON);
        iFileParserStrategy.doParser("11111");
    }
}

class FileParserStrageyService {
    private final Map<FileTypes,IFileParserStrategy> fileParserStrategyMap =
            Map.of(FileTypes.XML,new XmlParser(),FileTypes.JSON,new JsonParser());
    public IFileParserStrategy getParser(FileTypes fileTypes){
        return fileParserStrategyMap.get(fileTypes);
    }
}

enum FileTypes {
    XML,JSON;
}

//각각의 타입들은 해당 interface를 HAS-A 관계로 존재한다.
interface IFileParserStrategy {
    void doParser(String content);
}

class XmlParser implements IFileParserStrategy {
    @Override
    public void doParser(String content) {
        System.out.println("XML Parser");
    }
}

class JsonParser implements IFileParserStrategy{
    @Override
    public void doParser(String content) {
        System.out.println("JSON Parser");
    }
}