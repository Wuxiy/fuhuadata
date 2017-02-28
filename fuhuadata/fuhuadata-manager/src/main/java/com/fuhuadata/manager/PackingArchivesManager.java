package com.fuhuadata.manager;


import com.fuhuadata.domain.PackingArchives;
import com.fuhuadata.domain.query.PackingArchivesQuery;
import com.fuhuadata.domain.query.Result;

import java.util.List;

/**
 * 包材档案Manager
 * Created by intanswer on 2017/1/23.
 */
public interface PackingArchivesManager {

    public PackingArchives addPackingArchives(PackingArchives packingArchives);

    public PackingArchives getPackingArchivesById(int id);

    public boolean updatePackingArchivesById(int id,PackingArchives packingArchives);

    public boolean deletePackingArchivesById(int id);

    public List<PackingArchives> getPackingArchivesByPId(int id);

    public List<PackingArchives> getPackingArchivesByQuery(PackingArchivesQuery packingArchivesQuery);

    public Result<List<PackingArchives>> getPackingArchivesByPage(PackingArchivesQuery packingArchivesQuery);

    public int count(PackingArchivesQuery packingArchivesQuery);


}
