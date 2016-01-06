package com.nick

import com.nick.domain.*
import com.nick.service.*

import org.springframework.beans.factory.annotation.*
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*
import org.springframework.format.annotation.*
/**
 * Restful API
 *
 * @author Nick Tseng
 * @since 1.0
 */
@CrossOrigin
@Controller
class RestController {

    @Autowired
    private TypeRepository typeRepository
    @Autowired
    private RecordRepository recordRepository


    /**
     * 首頁.
     */
    @RequestMapping("/index")
    public String index() { }

    /**
     * GET /create
     * 新增記帳資料.
     */
    @RequestMapping("/create")
    public boolean create(@RequestBody Record item) {
        try {
            recordRepository.save(item)
        }
        catch (Exception ex) {
            return false
        }
        true
    }

    /**
     * GET /create
     * 取得初始化資料.
     */
    @RequestMapping("/daily")
    public @ResponseBody Object queryDaily() {
        Date startDate = new Date()
        Date endDate = new Date()
        startDate.set(hourOfDay: 0, minute: 0, second: 0)
        endDate.set(hourOfDay: 23, minute: 59, second: 59)

        def dailyList = recordRepository.findByRecordDateBetween(startDate, endDate)
        def typeList = typeRepository.findAll()

        def result = [daily: dailyList, types: typeList]
        return result
    }

    /**
     * PUT /update
     * 更新資料.
     */
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public @ResponseBody boolean update(@RequestBody Record item) {
        return recordRepository.saveAndFlush(item)
    }

    /**
     * DELETE /delete
     * 刪除資料.
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public @ResponseBody boolean delete(@PathVariable long id) {
        try {
            recordRepository.delete(id)
        }
        catch (Exception ex) {
            return false
        }
        return true
    }

    /**
     * GET /search
     * 查詢資料.
     */
    @RequestMapping("/search")
    public @ResponseBody List<Record> search(@DateTimeFormat(pattern="yyyy-MM-dd") Date startDate,
                                             @DateTimeFormat(pattern="yyyy-MM-dd") Date endDate) {
        recordRepository.findByRecordDateBetween(startDate, endDate)
    }

}
