package Devcos.AIBE.study_250305.til_collection;

import Devcos.AIBE.study_250305.til_collection.model.dto.Repo;
import Devcos.AIBE.study_250305.til_collection.service.github.TILService;
import Devcos.AIBE.study_250305.til_collection.service.github.TILServiceImpl;
import Devcos.AIBE.study_250305.til_collection.util.file.CSVReader;
import Devcos.AIBE.study_250305.til_collection.util.file.CSVReaderImpl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.Writer;
import java.util.List;
import java.util.logging.Logger;

public class Application {
    static List<Repo> repos;
    ;

    public static void main(String[] args) {
        Logger logger = Logger.getLogger(Application.class.getName());
        CSVReader reader = new CSVReaderImpl();

        try {
            repos = reader.read("Devcos.AIBE.study_250305.til_collection.til.csv");
            logger.info(repos.toString());
        } catch (FileNotFoundException e) {
            logger.severe(e.getMessage());
        }

//        TILService service = new TILServiceImpl();
        // 유저별-TIL csv를 만들 것
//        for (Repo repo : repos) {
//            List<TIL> tils = service.getTIL(repo);
//            logger.info(tils.toString());
//            // 파일로 나올 예정
//        }
//        repos.stream().map(service::getTIL).map(Object::toString).forEach(logger::info);

//        for (Repo repo : repos) {
//            File file = new File(repo.name() + ".md");
//            try (Writer writer = new FileWriter(file)) {
//                file.createNewFile();
////                logger.info(service.getTIL(repo).toString());
//                writer.append(service.getTIL(repo).toString());
//            } catch (Exception e) {
//                logger.severe(e.getMessage());
//            }
//        }
        repos.forEach(Application::handleRepo);
    }

    private static void handleRepo(Repo repo) {
        TILService service = new TILServiceImpl();

//        for (Repo repo : repos) {
        File file = new File(repo.name() + ".md");
        try (Writer writer = new FileWriter(file)) {
            file.createNewFile();
//                logger.info(service.getTIL(repo).toString());
            writer.append(service.getTIL(repo).toString());
        } catch (Exception e) {
//                logger.severe(e.getMessage());
        }
    }

}

