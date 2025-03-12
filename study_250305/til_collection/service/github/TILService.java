package Devcos.AIBE.study_250305.til_collection.service.github;

import Devcos.AIBE.study_250305.til_collection.model.dto.TIL;
import Devcos.AIBE.study_250305.til_collection.model.dto.Repo;

import java.util.List;

public interface TILService {
    List<TIL> getTIL(Repo repo) throws Exception;
}
