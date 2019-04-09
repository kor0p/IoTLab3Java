package ua.lviv.iot.security;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ua.lviv.iot.security.models.Equity;

@RestController
public class EquityController {

  @Autowired
  private EquityRepository equityRepository;

  @RequestMapping(value = "/equity", method = RequestMethod.GET)
  public List<Equity> getEquities() {
    return (List<Equity>) equityRepository.findAll();
  }

  @RequestMapping(value = "/equity/{id}", method = RequestMethod.GET)
  public Equity getEquity(@PathVariable Integer id) {
    return equityRepository.findById(id).get();
  }

  @RequestMapping(value = "/equity", method = RequestMethod.POST)
  public Equity postEquity(@RequestBody Equity equity) {
    return equityRepository.save(equity);
  }

  @RequestMapping(value = "/equity/{id}", method = RequestMethod.PUT)
  public Equity updateEquity(@RequestBody Equity newEquity, @PathVariable Integer id) {
    return equityRepository.findById(id)
    		.map(equity -> {
      newEquity.setId(id);
      return equityRepository.save(newEquity);
    }).orElseThrow();
  }

  @RequestMapping(value = "/equity/{id}", method = RequestMethod.DELETE)
  public Equity deleteEquity(@PathVariable Integer id) {
    Equity temp = getEquity(id);
    equityRepository.deleteById(id);
    return temp;
  }
}