package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.service.CarServiceImpl;

/*
    Контроллер - это класс который дает ссылку на html страницу
	В контроллере В ОСНОВНОМ находятся разные методы и каждый метод соответствует одному url, и возвращают они В ОСНОВНОМ
	строку String с названием представления html которое надо показывать пользователю. Могут возвращать json
*/

@Controller // контроллер - это тот же компонент, только с дополнительными возможностями
public class CarsController {

//    @GetMapping("/cars")
//    public String printCars(ModelMap model) {
//        List<String> cars = new ArrayList<>();
//        cars.add("Cars list:");
//       // model.addAttribute("Текст из CarsController", "табилчка" );
//        model.addAttribute("cars", Arrays.asList(
//                new Car("Model1", "series1", 200),
//                new Car("Model2", "series2", 250),
//                new Car("Model3", "series3", 300),
//                new Car("Model4", "series4", 350),
//                new Car("Model5", "series5", 400)
//        ));
//        return "cars.html";
//    }

    private final CarServiceImpl carService;

    //@Autowired
    public CarsController(CarServiceImpl carService) {
        this.carService = carService;
    }

    // Метод отвечающий за то, что отображается в html странице
    @GetMapping(value = "/cars") // при переходе в браузере на "/cars" мы попадем на метод printCars и он вернет cars.html
    public String printCars(@RequestParam(name = "count", required = false, defaultValue = "5") int count, ModelMap model) {
        model.addAttribute("cars", carService.getCarsList(count));
        return "cars";
    }
}
