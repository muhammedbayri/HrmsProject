package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.JobSeekerImageService;
import kodlamaio.hrms.core.adapters.abstracts.CloudinaryService;
import kodlamaio.hrms.core.utilities.results.*;
import kodlamaio.hrms.dataAccess.abstracts.JobSeekerImageDao;
import kodlamaio.hrms.entities.concretes.JobSeekerImage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

@Service
public class JobSeekerImageManager implements JobSeekerImageService {

    JobSeekerImageDao jobSeekerImageDao;
    CloudinaryService cloudinaryService;

    @Autowired
    public JobSeekerImageManager(JobSeekerImageDao jobSeekerImageDao, CloudinaryService cloudinaryService) {
        super();
        this.jobSeekerImageDao = jobSeekerImageDao;
        this.cloudinaryService = cloudinaryService;
    }

    @Override
    public Result add(JobSeekerImage jobSeekerImage) {
        if(this.jobSeekerImageDao.save(jobSeekerImage) != null) {
            return new SuccessResult();
        }
        return new ErrorResult();
    }

    @Override
    public DataResult<JobSeekerImage> upload(MultipartFile image) {
        DataResult<Map<String, String>> result = this.cloudinaryService.upload(image);

        if(result.isSuccess()) {

            JobSeekerImage jobSeekerImage= new JobSeekerImage();
            jobSeekerImage.setImageUrl(result.getData().get("url"));
            Result addingResult = this.add(jobSeekerImage);
            if (addingResult.isSuccess()) {
                return new SuccessDataResult<JobSeekerImage>(jobSeekerImage);
            }
        }
        return new ErrorDataResult<JobSeekerImage>(null,"Dosya yüklenemedi");
    }
}
