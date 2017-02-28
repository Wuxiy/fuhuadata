package com.fuhuadata.service;

import com.fuhuadata.domain.PackingArchives;
import com.fuhuadata.domain.query.PackingArchivesQuery;
import com.fuhuadata.domain.query.Result;

import java.util.List;

/**
 * Created by intanswer on 2017/1/23.
 */
public interface PackingArchivesService {

    public Result<PackingArchives> addPackingArchives(PackingArchives packingArchives);

    public Result updatePackingArchivesById(int id, PackingArchives packingArchives);

    public Result deletePackingArchivesById(int id);

    public Result<PackingArchives> getAllPackingArchives();

    public Result<List<PackingArchives>> getPackingArchivesByQuery(PackingArchivesQuery packingArchivesQuery);

    public Result<PackingArchives> getPackingArchivesById(int id);

    public Result<List<PackingArchives>> getPackingArchivesByPId(int id);

    public Result<List<PackingArchives>> getPackingArchivesByPage(PackingArchivesQuery packingArchivesQuery);

    public Result<Integer> count(PackingArchivesQuery packingArchivesQuery);

}