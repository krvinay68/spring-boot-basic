package com.krvinay.controller;

import java.util.List;
import java.util.ArrayList;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BasicController {
	
	 //dynamic port
    // String port=environment.getProperty("local.server.port");

	@Autowired
	MessageSource messageSource;

	// dyanmic port
	@Autowired
	Environment environment;
	
	@GetMapping("/module")
	public List<String> modules(){
		
		
		List<String> list=new ArrayList<String>();
		list.add("IMPLEMENTATION JPA");
		list.add("IMPLEMENTATION HATEOAS(HYPERLINK)");
		list.add("IMPLEMENTATION OF LINK AND SETTING OF RESPONSE BODY IN POST CALL ");
		list.add("IMPLEMENTATION OF EXCEPTION");
		list.add("IMPLEMENTATION SWAGGER AND OPEN API");
		list.add("IMPLEMENTATION HAL");
		list.add("IMPLEMENTATION OF RESPONSE FILTERING");
		list.add("IMPLEMENTATION OF INTERNATIONALIZATION");
		list.add("IMPLEMENTATION OF VERSIONING");
		list.add("IMPLEMENTATION OF CONTENT NEGOTIATION NOTHING EITHER JSON RESPONSE OR XML");
		list.add("IMPLEMENTATION OF DYNAMIC PORT");
		return list;
		
	}

	// VERSIONING
	/*
	 * Variety of options :- ->URL -- In this case we will create different urls for
	 * the different versions ->REQUEST PARAMETERS --By using either params
	 * or @RequestParam ->HEADER -- headers=X-API-VERSION=1 OR
	 * headers=X-API-VERSION=2 ->MEDIA TYPE -- "Accept"
	 */

	// ---- URL --------------------------
	@GetMapping("/versioning")
	public String versioning() {
		return "heelo";
	}
	@GetMapping("/versioning/v2")
	public String versioningv2() {
		return "heelo good morning";
	}
	
	// ---- REQUEST PARAMETERS-----------
	@GetMapping(path = "/versioning", params = "version=1")
	public String versioning_RequestParam_v1() {
		return "Using  REQUEST PARAMETERS v1";
	}
	@GetMapping(path = "/versioning", params = "version=2")
	public String versioning_RequestParam_v2() {
		return "Using  REQUEST PARAMETERS v2";
	}
	// localhost:8080/versioning?params=new
	@GetMapping("/versioning/params")
	public String versioning_RequestParam_newway(@RequestParam String v1) {
		return "heelo" + v1;
	}

	// ---- HEADERS -----------
	@GetMapping(path = "/versioning/header", headers = "X-API-VERSION=1")
	public String versioning_Requestheaders_v1() {
		return "heelo";
	}
	@GetMapping(path = "/versioning/header", headers = "X-API-VERSION=2")
	public String versioning_Requestheaders_v2() {
		return "heelo_world";
	}

	// ---- MEDIA TYPE -----------
	@GetMapping(path = "/versioning/media", produces = "application/vn.company.app-v1+json")
	public String versioning_Requestmedia_v1() {
		return "heelo";
	}
	@GetMapping(path = "/versioning/media", produces = "application/vn.company.app-v2+json")
	public String versioning_Requestmedia_v2() {
		return "heelo_world";
	}
	
	//Implementing Internationalization
    /**
     * Internationalization -i18n
     * Rest api might have consumes from around the world
     * Typically HTTP Request Header "Accept-Language is used
     * "Accept-Language" indicates natural language and locale that the consumer prefers
     *    eg en -English
     *    nl -Dutch
     *    fr -french
     *     
     */
    @GetMapping("/internationalization")
    public String hello(){
        Locale locale=LocaleContextHolder.getLocale();
        return messageSource.getMessage("good.morning.message", null,"Default Messsage", locale);
    }
    
    /**
     * Sample code for reference
     * 
     */
    
    /*
    @PostMapping("/asset/create")    
    public ResponseEntity<AssetInfo> add(@Valid @RequestBody AssetInfo assetInfo){
        AssetInfo asset=assetDao.saveData(assetInfo);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().
                               path("/{id}").buildAndExpand(asset.getId()).toUri();
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setLocation(uri);
        return new ResponseEntity<AssetInfo>(asset, responseHeaders, HttpStatus.CREATED);
        //return ResponseEntity.created(uri).build();
      
    }
    @GetMapping(path="/asset/findall")
    public List<AssetInfo> findall(){
        List<AssetInfo> assetInfo=  assetDao.getAll();
        return assetInfo;
    }
    //Need to implement find by id logic
    @GetMapping(path="/asset/find")
    public EntityModel<AssetInfo> findOne(){        
        AssetInfo asetInfo=null;
        //HATEOAS property for creating hyperlink
        EntityModel<AssetInfo> entityModel=EntityModel.of(asetInfo);
        WebMvcLinkBuilder link= linkTo(methodOn(this.getClass()).findall());
        entityModel.add(link.withRel("all-details"));
        return entityModel;
    }
    //Need to implement find by id logic for dynamic filtering
    @GetMapping(path="/asset/find/v2")
    public MappingJacksonValue findOned(){        
        List<AssetInfo> asetInfo=null;
        MappingJacksonValue mapping=new MappingJacksonValue(asetInfo);
        SimpleBeanPropertyFilter filter=SimpleBeanPropertyFilter.filterOutAllExcept("field1","field2");
        FilterProvider filters=new SimpleFilterProvider().addFilter("somefilterbean", filter);
        mapping.setFilters(filters);
        return mapping;
    }*/
    

}
