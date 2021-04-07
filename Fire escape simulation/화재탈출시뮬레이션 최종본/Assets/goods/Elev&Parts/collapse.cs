using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.SceneManagement;

public class collapse : MonoBehaviour {
    public bool enable = false;
    public GameObject dkdk;
    public float wait = 8;
    public GameObject elevator;
    private float time = 0;
    public GameObject sound;
    public GameObject sound1;

    void Update()//for test
    {
        if (enable)
        {
            elevator.AddComponent<Rigidbody>();
            sound.SendMessage("enableSound");
            sound1.SendMessage("enableSound");
            dkdk.GetComponent<BoxCollider>().isTrigger = false;
            time += Time.deltaTime;
        }
        if (time >= 1.5f) {
            SceneManager.LoadScene("Elev");
        }

    }
    private void OnTriggerStay(Collider col)
    {
        if (col.tag == "Player" && !enable)
        {
            Debug.Log("waiting: "+wait);
            wait -= Time.deltaTime;
            if (wait <= 0)
            {
                enable = true;
            }
        }

    }
}
