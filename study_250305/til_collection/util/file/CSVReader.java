package Devcos.AIBE.study_250305.til_collection.util.file;

import Devcos.AIBE.study_250305.til_collection.model.dto.Repo;

import java.io.FileNotFoundException;
import java.util.List;

public interface CSVReader {
    List<Repo> read(String path) throws FileNotFoundException;
}
