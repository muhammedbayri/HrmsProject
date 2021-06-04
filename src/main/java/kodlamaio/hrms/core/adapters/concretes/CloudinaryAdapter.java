package kodlamaio.hrms.core.adapters.concretes;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import kodlamaio.hrms.core.adapters.abstracts.CloudinaryService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Service
public class CloudinaryAdapter implements CloudinaryService {

    private final Cloudinary cloudinary;
    private Map<String,String> valuesMap = new HashMap<>();

    @Autowired
    public CloudinaryAdapter() {
        valuesMap.put("cloud_name","");
        valuesMap.put("api_key","");
        valuesMap.put("api_secret","");
        cloudinary = new Cloudinary(valuesMap);
    }

    @Override
    public DataResult<Map<String, String>> upload(MultipartFile multipartFile) {
        File file;

        try {
            file = convert(multipartFile);
            Map<String,String> result = cloudinary.uploader().upload(file, ObjectUtils.emptyMap());
            file.delete();
            return new SuccessDataResult<>(result);
        }
        catch (Exception e){
            e.printStackTrace();
            return new ErrorDataResult<>("File not uploaded");
        }
    }

    private File convert(MultipartFile multipartFile) throws IOException {
        File file = new File(multipartFile.getOriginalFilename());
        FileOutputStream stream = new FileOutputStream(file);
        stream.write(multipartFile.getBytes());
        stream.close();

        return file;
    }
}
