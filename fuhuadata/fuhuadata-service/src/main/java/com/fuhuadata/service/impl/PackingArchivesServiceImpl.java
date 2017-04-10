package com.fuhuadata.service.impl;

import com.ctc.wstx.util.StringUtil;
import com.fuhuadata.domain.PackingArchives;
import com.fuhuadata.domain.query.PackingArchivesQuery;
import com.fuhuadata.domain.query.Result;
import com.fuhuadata.manager.PackingArchivesManager;
import com.fuhuadata.service.PackingArchivesService;
import com.fuhuadata.vo.ImagePathVO;
import com.fuhuadata.vo.PackingArchivesVO;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.ArrayList;
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
            ids=ids.replace("[","");
            ids=ids.replace("]","");
            ids=ids.replace("\"","");
            packingArchives.setAssociatedPackingId(ids);
            if(packingArchives.getImagePath().equals("[]")){
                packingArchives.setImagePath("");
            }
            String suitableType=packingArchives.getSuitableType();
            packingArchives.setSuitableType( suitableType.replace("[","").replace("]","").replace("\"",""));
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
            String ids=packingArchives.getAssociatedPackingId();

            if(ids!=null&&ids.length()>0) {
                packingArchives.setAssociatedPackingId(ids.replace("[", "").replace("]", "").replace("\"", ""));
            }

            if(packingArchives.getImagePath()!=null&&packingArchives.getImagePath().equals("[]")){
                packingArchives.setImagePath("");
            }
            String suitableType=packingArchives.getSuitableType();
            if(suitableType!=null&&suitableType.length()>0) {
                packingArchives.setSuitableType(suitableType.replace("[", "").replace("]", "").replace("\"", ""));
            }
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
                if(imagePath!=null&&imagePath.length()>0){
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
                if(ids != null&& ids.length()>0) {
                    packingArchivesVO.setNodes(packingArchivesManager.getPackingArchivesByIds(ids));
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
    public Result<List<PackingArchives>> getPakcingArchivesByIds(String[] ids) {
        Result<List<PackingArchives>> result = new Result<List<PackingArchives>>();
        try{
           /* List<PackingArchives> list = new ArrayList<PackingArchives>();*/
          /*  if(ids!=null){
                for(int i=0;i<ids.length;i++){
                    PackingArchives packingArchives = new PackingArchives();
                    packingArchives=packingArchivesManager.getPackingArchivesById(Integer.parseInt(ids[i]));
                    list.add(packingArchives);
                }
                result.addDefaultModel(list);
            }*/
          if(ids!=null&&ids.length>0) {
              String idsStr = StringUtils.join(ids, ",");
              System.out.println(idsStr);
              result.addDefaultModel("PackingArchivesList",packingArchivesManager.getPackingArchivesByIds(idsStr));
          }
        }catch(Exception e){
            log.error("根据ids获取包材信息错误",e);
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
