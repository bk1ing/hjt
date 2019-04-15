package com.bk.common.cfg;

import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.async.DeferredResult;

import com.google.common.base.Function;
import com.google.common.base.Optional;
import com.google.common.base.Predicate;

import springfox.documentation.RequestHandler;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@ConfigurationProperties(prefix = "swagger2")
public class Swagger2Config
{

	/**
	 * 获取API标题
	 */
	public String title;
	public String version;
	public String description;
	public List<String> basePackage;

	@Bean
	public Docket createRestApi()
	{
		return new Docket(DocumentationType.SWAGGER_2).genericModelSubstitutes(DeferredResult.class)
				.apiInfo(buildApiInf()).select().apis(Swagger2Config.basePackage(basePackage))
				.paths(PathSelectors.any()).build();
	}

	private ApiInfo buildApiInf()
	{
		return new ApiInfoBuilder().title(title).description(description).version(version).build();
	}

	public static Predicate<RequestHandler> basePackage(final List<String> basePackage)
	{
		return new Predicate<RequestHandler>()
		{

			@Override
			public boolean apply(RequestHandler input)
			{
				return declaringClass(input).transform(handlerPackage(basePackage)).or(true);
			}
		};
	}

	/**
	 * 处理包路径配置规则,支持多路径扫描匹配
	 * 
	 * @param basePackage 扫描包路径
	 * @return Function
	 */
	private static Function<Class<?>, Boolean> handlerPackage(final List<String> basePackage)
	{
		return new Function<Class<?>, Boolean>()
		{

			@Override
			public Boolean apply(Class<?> input)
			{
				for (String strPackage : basePackage)
				{
					boolean isMatch = input.getPackage().getName().startsWith(strPackage);
					if (isMatch)
					{
						return true;
					}
				}
				return false;
			}
		};
	}

	private static Optional<? extends Class<?>> declaringClass(RequestHandler input)
	{
		return Optional.fromNullable(input.declaringClass());
	}

	public String getTitle()
	{
		return title;
	}

	public void setTitle(String title)
	{
		this.title = title;
	}

	public String getVersion()
	{
		return version;
	}

	public void setVersion(String version)
	{
		this.version = version;
	}

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	public List<String> getBasePackage()
	{
		return basePackage;
	}

	public void setBasePackage(List<String> basePackage)
	{
		this.basePackage = basePackage;
	}
}
