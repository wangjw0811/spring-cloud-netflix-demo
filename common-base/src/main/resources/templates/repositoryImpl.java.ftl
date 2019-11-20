package ${package.RepositoryImpl};

import ${package.Entity}.${entity};
import ${package.Mapper}.${table.mapperName};
import ${package.Repository}.${table.repositoryName};
import ${superServiceImplClassPackage};
import org.springframework.stereotype.Repository;

/**
 * <p>
 * ${table.comment!} 服务实现类
 * </p>
 *
 * @author ${author}
 * @since ${date}
 */
@Repository
<#if kotlin>
open class ${table.repositoryImplName} : ${superServiceImplClass}<${table.mapperName}, ${entity}>(), ${table.repositoryName} {

}
<#else>
public class ${table.repositoryImplName} extends ${superServiceImplClass}<${table.mapperName}, ${entity}> implements ${table.repositoryName} {

}
</#if>
