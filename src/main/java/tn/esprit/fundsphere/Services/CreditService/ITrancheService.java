package tn.esprit.fundsphere.Services.CreditService;

import tn.esprit.fundsphere.Entities.CrediMangment.Tranche;

import java.util.List;

public interface ITrancheService {
    public Tranche addTranche(Tranche tranche);
    public void deleteTranche(Long idTranche);
    public Tranche updateTranche(Tranche tranche);
    public List<Tranche> getAllTranches();
    public Tranche getTranche(Long idTranche);
    public void assignTranchesToCredit(Long idCredit, Long idTranche);
    public void dessignerTrancheToCredit(Long idTranche);
}
