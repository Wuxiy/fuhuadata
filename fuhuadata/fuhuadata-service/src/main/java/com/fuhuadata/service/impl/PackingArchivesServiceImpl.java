package com.fuhuadata.service.impl;

import com.fuhuadata.domain.PackingArchives;
import com.fuhuadata.domain.query.PackingArchivesQuery;
import com.fuhuadata.domain.query.Result;
import com.fuhuadata.manager.PackingArchivesManager;
import com.fuhuadata.service.PackingArchivesService;
import com.fuhuadata.vo.ImagePathVO;
import com.fuhuadata.vo.PackingArchivesVO;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.List;

/**
 * Created by intanswer on 2017/1/23.
 */
public class PackingArchivesServiceImpl implements PackingArchivesService {
    private final static Log log = LogFactory.getLog(UserAccountServiceImpl.class);
    private PackingArchivesManager packingArchivesManager;
    @Override
    public Result<PackingArchives> addPackingArchives(PackingArchives packingArchives) {
        Result<PackingArchives> result = new Result<PackingArchives>();

        try {
            String ids=packingArchives.getAssociatedPackingId();
            System.out.println(ids);
            ids=ids.replace("[","");
            ids=ids.replace("]","");
            ids=ids.replace("\"","");
            packingArchives.setAssociatedPackingId(ids);
            if(packingArchives.getImagePath().equals("[]")){
                packingArchives.setImagePath("");
            }
            result.addDefaultModel(packingArchivesManager.addPackingArchives(packingArchives));
        } catch (Exception e) {
            result.setSuccess(false);
            // 打印日志
            log.error("添加包材档案失败",e);
        }
        return result;

    }

    @Override
    public Result updatePackingArchivesById(int id, PackingArchives packingArchives) {
        Result result = new Result();
        try {
            result.setSuccess(packingArchivesManager.updatePackingArchivesById(id, packingArchives));
        } catch (Exception e) {
            result.setSuccess(false);
            // 打印日志
            log.error("修改包材档案信息失败",e);
        }
        return result;
    }

    @Override
    public Result deletePackingArchivesById(int id) {
        Result result = new Result();
        try {
            result.setSuccess(packingArchivesManager.deletePackingArchivesById(id));
        } catch (Exception e) {
            result.setSuccess(false);
            // 打印日志
            log.error("根据id删除包材档案错误",e);
        }
        return result;
    }

    @Override
    public Result<PackingArchives> getAllPackingArchives() {
            return null;
    }

    @Override
    public Result<List<PackingArchives>> getPackingArchivesByQuery(PackingArchivesQuery packingArchivesQuery) {
        Result<List<PackingArchives>> result = new Result<List<PackingArchives>>();
        try {
            result.addDefaultModel("PackingArchives", packingArchivesManager.getPackingArchivesByQuery(packingArchivesQuery));
        } catch (Exception e) {
            result.setSuccess(false);
            // 打印日志
            log.error("查询包材档案错误",e);
        }
        return result;
    }

    /**
     * 获取主包材和关联包材
     * @param id
     * @return
     */
    @Override
    public Result<PackingArchivesVO> getPackingArchivesById(int id) {
        Result<PackingArchivesVO> result = new Result<PackingArchivesVO>();
        try {
            PackingArchivesVO packingArchivesVO = new PackingArchivesVO();
            PackingArchives packingArchives = packingArchivesManager.getPackingArchivesById(id);
            if(packingArchives == null){
                result.setSimpleErrorMsg(0, "当前包材档案数据不存在，请重试");
            }else {
                packingArchivesVO.setPack(packingArchives);
                String imagePath = packingArchives.getImagePath();
                if(imagePath!=null){
                    JSONArray json = JSONArray.fromObject(imagePath); // 首先把字符串转成JSONArray对象
                    if (json.size() > 0) {
                        for (int i = 0; i < json.size(); i++) {
                            JSONObject job = json.getJSONObject(i);  // 遍历 jsonarray 数组，把每一个对象转成 json 对象
                            ImagePathVO imagePathVO =new ImagePathVO();
                            imagePathVO.setName((String) job.get("name"));
                            imagePathVO.setPath((String)job.get("path"));
                            packingArchivesVO.addImagePath(imagePathVO);
                        }
                    }

                }
                String ids = packingArchives.getAssociatedPackingId();
                if(ids != null) {
                    String[] idArray = ids.split(",");

                    for (int i = 0; i < idArray.length; i++) {
                        System.out.println(idArray[i]);
                        PackingArchives packingArchivesNode = packingArchivesManager.getPackingArchivesById(Integer.parseInt(idArray[i]));
                        packingArchivesVO.addNodes(packingArchivesNode);
                    }
                }
                result.addDefaultModel("PackingArchives", packingArchivesVO);
            }
        } catch (Exception e) {
            result.setSuccess(false);
            // 打印日志
            log.error("根据id获取包材档案错误",e);
        }
        return result;
    }

    @Override
    public Result<List<PackingArchives>> getPackingArchivesByPId(int id) {
        Result<List<PackingArchives>> result = new Result<List<PackingArchives>>();
        try{
            result.addDefaultModel("PackingArchives",packingArchivesManager.getPackingArchivesByPId(id));
        }catch(Exception e){
            result.setSuccess(false);
            log.error("根据包材目录树获取包材错误",e);
        }
        return result;
    }

    @Override
    public Result<List<PackingArchives>> getPackingArchivesByPage(PackingArchivesQuery packingArchivesQuery) {
        Result<List<PackingArchives>> result = new Result<List<PackingArchives>>();
        try {
            result = packingArchivesManager.getPackingArchivesByPage(packingArchivesQuery);
        } catch (Exception e) {
            result.setSuccess(false);
            // 打印日志
            log.error("分页获取包材档案错误",e);
        }
        return result;
    }

    @Override
    public Result<Integer> count(PackingArchivesQuery packingArchivesQuery) {
        Result<Integer> result = new Result<Integer>();
        try {
            result.addDefaultModel(packingArchivesManager.count(packingArchivesQuery));
        } catch (Exception e) {
            result.setSuccess(false);
            // 打印日志
            log.error("查询包材档案数量错误",e);
        }
        return result;
    }

    public PackingArchivesManager getPackingArchivesManager(){
        return this.packingArchivesManager;
    }

    public void setPackingArchivesManager(PackingArchivesManager packingArchivesManager) {
        this.packingArchivesManager = packingArchivesManager;
    }
}
